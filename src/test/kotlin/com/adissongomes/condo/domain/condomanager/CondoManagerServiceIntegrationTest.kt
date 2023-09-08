package com.adissongomes.condo.domain.condomanager

import com.adissongomes.condo.CondoApplication
import com.adissongomes.condo.domain.common.AddressVO
import com.adissongomes.condo.domain.condo.dto.CondoBuildingCreationDTO
import com.adissongomes.condo.domain.condo.dto.CondoCreationDTO
import com.adissongomes.condo.domain.condo.dto.CondoDTO
import com.adissongomes.condo.domain.condo.port.input.CondoService
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerCreationDTO
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerDTO
import com.adissongomes.condo.domain.condomanager.exception.CondoManagementRestrictionException
import com.adissongomes.condo.domain.condomanager.port.input.CondoManagerService
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import com.ninjasquad.springmockk.SpykBean
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import java.util.UUID

@SpringBootTest
@ComponentScan(basePackageClasses = [CondoApplication::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation::class)
class CondoManagerServiceIntegrationTest {

    @Autowired
    private lateinit var condoManagerService: CondoManagerService

    @Autowired
    private lateinit var condoService: CondoService

    @SpykBean
    private lateinit var condoManagerRepository: CondoManagerRepository

    private lateinit var manager: CondoManagerDTO
    private lateinit var condo: CondoDTO

    @Test
    @Order(1)
    fun `should create a condo manager`() {
        manager = condoManagerService.create(CondoManagerCreationDTO("Manager Integration", "29269913000100"))
        assertNotNull(manager)
    }

    @Test
    @Order(2)
    fun `should create a condo`() {
        val address = AddressVO("Street", "1", "A", "68000000")
        condo = condoService.create(CondoCreationDTO("Condo Integration", address))
        assertNotNull(condo)
    }

    @Test
    @Order(3)
    fun `should associate the condo manager`() {
        condoService.associateManager(condo.id, manager.id)
        verify { condoManagerRepository.associateCondo(any(), any()) }
    }

    @Test
    @Order(4)
    fun `should add building in the condo`() {
        val creationDTO = CondoBuildingCreationDTO("Building Integration", "Integration sample")
        condo = condoService.createBuilding(condo.id, manager.id, creationDTO)
        assertNotNull(condo)
        assertEquals(1, condo.buildings.size)
    }

    @Test
    @Order(5)
    fun `should remove building from the condo`() {
        condo = condoService.removeBuilding(manager.id, condo.buildings[0].id)
        assertNotNull(condo)
        assertEquals(0, condo.buildings.size)
    }

    @Test
    @Order(6)
    fun `should fail when try to add building in the condo without be the manager`() {
        val localManager = condoManagerService.create(CondoManagerCreationDTO("Temporary", "12123123111100"))
        val creationDTO = CondoBuildingCreationDTO("Building Integration", "Integration sample")
        assertThrows<CondoManagementRestrictionException> {
            condoService.createBuilding(
                condo.id,
                localManager.id,
                creationDTO
            )
        }
    }

    @Test
    @Order(7)
    fun `should fail when try to add building in the condo with an inexistent manager`() {
        val creationDTO = CondoBuildingCreationDTO("Building Integration", "Integration sample")
        assertThrows<NoSuchElementException> {
            condoService.createBuilding(
                condo.id,
                UUID.randomUUID(),
                creationDTO
            )
        }
    }
}
