package com.adissongomes.condo.data.condo

import com.adissongomes.condo.domain.condo.Condo
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
            it.buildings.any { it.id == buildingId }
        }.firstOrNull()
        return Optional.ofNullable(condo)
    }

    override fun findAll(): List<Condo> {
        return data.values.toList()
    }

}
