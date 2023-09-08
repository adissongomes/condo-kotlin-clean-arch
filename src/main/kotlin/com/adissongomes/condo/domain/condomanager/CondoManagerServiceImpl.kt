package com.adissongomes.condo.domain.condomanager

import com.adissongomes.condo.domain.condomanager.dto.CondoManagerCreationDTO
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerDTO
import com.adissongomes.condo.domain.condomanager.dto.toDTO
import com.adissongomes.condo.domain.condomanager.dto.toDomain
import com.adissongomes.condo.domain.condomanager.port.input.CondoManagerService
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import java.util.UUID

internal class CondoManagerServiceImpl(
    private val condoManagerRepository: CondoManagerRepository,
) : CondoManagerService {
    override fun create(condoManagerCreationDTO: CondoManagerCreationDTO): CondoManagerDTO {
        val condoManager = condoManagerCreationDTO.toDomain().also {
            it.validate()
        }
        return condoManagerRepository.save(condoManager).toDTO()
    }

    override fun fetchById(id: UUID): CondoManagerDTO {
        return condoManagerRepository.byId(id).orElseThrow().toDTO()
    }
}
