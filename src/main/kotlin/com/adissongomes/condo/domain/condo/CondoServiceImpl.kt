package com.adissongomes.condo.domain.condo

import com.adissongomes.condo.domain.condo.dto.CondoBuildingCreationDTO
import com.adissongomes.condo.domain.condo.dto.CondoCreationDTO
import com.adissongomes.condo.domain.condo.dto.CondoDTO
import com.adissongomes.condo.domain.condo.dto.toDTO
import com.adissongomes.condo.domain.condo.dto.toDomain
import com.adissongomes.condo.domain.condo.port.input.CondoService
import com.adissongomes.condo.domain.condo.port.output.CondoRepository
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import java.util.UUID

internal class CondoServiceImpl(
    private val condoRepository: CondoRepository,
    private val condoManagerRepository: CondoManagerRepository,
) : CondoService {

    override fun create(condoCreationDTO: CondoCreationDTO): CondoDTO {
        val condo = condoCreationDTO.toDomain().also { it.validate() }
        return condoRepository.save(condo).toDTO()
    }

    override fun getAll(): List<CondoDTO> {
        return condoRepository.findAll().map { it.toDTO() }
    }

    override fun associateManager(condoId: UUID, condoManagerId: UUID) {
        val condoManager = condoManagerRepository.byId(condoManagerId).orElseThrow()
        val condo = condoRepository.byId(condoId).orElseThrow()
        condoManagerRepository.associateCondo(condoManager, condo)
    }

    override fun createBuilding(condoId: UUID, condoManagerId: UUID, building: CondoBuildingCreationDTO): CondoDTO {
        val condo = condoRepository.byId(condoId).orElseThrow()
        checkManager(condoManagerId, condo)
        val condoBuilding = building.toDomain()
        condoBuilding.validate()
        return condoRepository.addBuilding(condo, condoBuilding).toDTO()
    }

    override fun removeBuilding(condoManagerId: UUID, buildingId: UUID): CondoDTO {
        val condo = condoRepository.byBuildingId(buildingId).orElseThrow()
        checkManager(condoManagerId, condo)
        return condoRepository.removeBuilding(buildingId).toDTO()
    }

    private fun checkManager(condoManagerId: UUID, condo: Condo) {
        condoManagerRepository.byId(condoManagerId)
            .orElseThrow()
            .run { this.canManage(condo) }
    }
}
