package com.adissongomes.condo.domain.condomanager.usecase

import com.adissongomes.condo.domain.common.Usecase
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerCreationDTO
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerDTO
import com.adissongomes.condo.domain.condomanager.dto.toDTO
import com.adissongomes.condo.domain.condomanager.dto.toDomain
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository

class CreateCondoManagerUsecase(private val condoManagerRepository: CondoManagerRepository): Usecase<CondoManagerCreationDTO, CondoManagerDTO> {

    override fun execute(input: CondoManagerCreationDTO): CondoManagerDTO {
        val condoManager = input.toDomain().also {
            it.validate()
        }
        return condoManagerRepository.save(condoManager).toDTO()
    }
}