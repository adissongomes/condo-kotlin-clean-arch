package com.adissongomes.condo.domain.condo.port.output

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condo.CondoBuilding
import java.util.Optional
import java.util.UUID

interface CondoRepository {
    fun save(condo: Condo): Condo
    fun byId(id: UUID): Optional<Condo>
    fun byBuildingId(buildingId: UUID): Optional<Condo>
    fun findAll(): List<Condo>
    fun addBuilding(condo: Condo, building: CondoBuilding): Condo
    fun removeBuilding(buildingId: UUID): Condo
}
