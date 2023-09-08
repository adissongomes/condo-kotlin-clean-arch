package com.adissongomes.condo.domain.condomanager

import com.adissongomes.condo.domain.condomanager.dto.CondoManagerCreationDTO
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CondoManagerServiceImplTest {

    @MockK(relaxed = true)
    private lateinit var repository: CondoManagerRepository

    @InjectMockKs
    private lateinit var service: CondoManagerServiceImpl

    @Test
    fun `should create a condo manager`() {
        service.create(CondoManagerCreationDTO("Condo MockK", "29269913000100"))
        verify { repository.save(any()) }
    }
}
