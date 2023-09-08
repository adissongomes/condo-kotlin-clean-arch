package com.adissongomes.condo.domain.condo.port.input

import com.adissongomes.condo.domain.condo.dto.CondoBuildingCreationDTO
import com.adissongomes.condo.domain.condo.dto.CondoCreationDTO
import com.adissongomes.condo.domain.condo.dto.CondoDTO
import java.util.UUID

interface CondoService {
    fun create(condoCreationDTO: CondoCreationDTO): CondoDTO
    fun getAll(): List<CondoDTO>
    fun associateManager(condoId: UUID, condoManagerId: UUID)
    fun createBuilding(condoId: UUID, condoManagerId: UUID, building: CondoBuildingCreationDTO): CondoDTO
    fun removeBuilding(condoManagerId: UUID, buildingId: UUID): CondoDTO
}
