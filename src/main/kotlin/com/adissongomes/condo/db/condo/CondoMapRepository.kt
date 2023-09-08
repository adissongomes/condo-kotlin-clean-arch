package com.adissongomes.condo.db.condo

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condo.CondoBuilding
import com.adissongomes.condo.domain.condo.port.output.CondoRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
class CondoMapRepository : CondoRepository {

    private val data = mutableMapOf<UUID, Condo>()

    override fun save(condo: Condo): Condo {
        data[condo.id] = condo
        return condo
    }

    override fun byId(id: UUID): Optional<Condo> {
        return Optional.ofNullable(data[id])
    }

    override fun byBuildingId(buildingId: UUID): Optional<Condo> {
        val condo = data.values.filter {
            it.buildings.filter { it.id == buildingId }.isNotEmpty()
        }.firstOrNull()
        return Optional.ofNullable(condo)
    }

    override fun findAll(): List<Condo> {
        return data.values.toList()
    }

    override fun addBuilding(condo: Condo, building: CondoBuilding): Condo =
        data[condo.id]?.let {
            val buildings = it.buildings.toMutableSet()
            buildings.add(building)
            val updatedCondo = Condo(it.id, it.name, it.address, buildings)
            save(updatedCondo)
        }
            ?: throw NoSuchElementException()

    override fun removeBuilding(building: CondoBuilding): Condo =
        byBuildingId(building.id).orElseThrow()
            .also {
                val buildings = it.buildings.toMutableSet()
                buildings.remove(building)
                val updatedCondo = Condo(it.id, it.name, it.address, buildings)
                save(updatedCondo)
            }
}
