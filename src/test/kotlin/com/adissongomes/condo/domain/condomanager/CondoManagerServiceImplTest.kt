package com.adissongomes.condo.domain.condomanager

import com.adissongomes.condo.domain.condomanager.dto.CondoManagerCreationDTO
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerDTO
import com.adissongomes.condo.domain.condomanager.usecase.CreateCondoManagerUsecase
import com.adissongomes.condo.domain.condomanager.usecase.GetCondoManagerByIdUsecase
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
class CondoManagerServiceImplTest {

    @MockK(relaxed = true)
    private lateinit var createCondoManagerUsecase: CreateCondoManagerUsecase

    @MockK(relaxed = true)
    private lateinit var getCondoManagerByIdUsecase: GetCondoManagerByIdUsecase

    @InjectMockKs
    private lateinit var service: CondoManagerServiceImpl

    @Test
    fun `should create a condo manager`() {
        val condoManagerCreationDTO = CondoManagerCreationDTO("Condo MockK", "29269913000100")
        service.create(condoManagerCreationDTO)
        verify { createCondoManagerUsecase.invoke(condoManagerCreationDTO) }
    }

    @Test
    fun `should get a condo manager by its id`() {
        every { getCondoManagerByIdUsecase.execute(any()) } returns mockkClass(CondoManagerDTO::class)
        val id = UUID.randomUUID()
        val condoManagerDTO = service.fetchById(id)
        assertNotNull(condoManagerDTO)
    }
}
