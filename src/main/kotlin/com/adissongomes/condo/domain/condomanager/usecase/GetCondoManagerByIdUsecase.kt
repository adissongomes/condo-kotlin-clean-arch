package com.adissongomes.condo.domain.condomanager.usecase

import com.adissongomes.condo.domain.common.Usecase
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerDTO
import com.adissongomes.condo.domain.condomanager.dto.toDTO
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import java.util.UUID

class GetCondoManagerByIdUsecase(private val condoManagerRepository: CondoManagerRepository) :
    Usecase<UUID, CondoManagerDTO> {

    override fun execute(input: UUID): CondoManagerDTO {
        return condoManagerRepository.byId(input).orElseThrow().toDTO()
    }
}
