package com.adissongomes.condo.domain.condomanager

import com.adissongomes.condo.domain.condomanager.dto.CondoManagerCreationDTO
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerDTO
import com.adissongomes.condo.domain.condomanager.dto.toDTO
import com.adissongomes.condo.domain.condomanager.port.input.CondoManagerService
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import com.adissongomes.condo.domain.condomanager.usecase.CreateCondoManagerUsecase
import com.adissongomes.condo.domain.condomanager.usecase.GetCondoManagerByIdUsecase
import java.util.UUID

internal class CondoManagerServiceImpl(
    private val createCondoManagerUsecase: CreateCondoManagerUsecase,
    private val getCondoManagerByIdUsecase: GetCondoManagerByIdUsecase
) : CondoManagerService {
    override fun create(condoManagerCreationDTO: CondoManagerCreationDTO): CondoManagerDTO =
        createCondoManagerUsecase(condoManagerCreationDTO)

    override fun fetchById(id: UUID): CondoManagerDTO = getCondoManagerByIdUsecase(id)
}
