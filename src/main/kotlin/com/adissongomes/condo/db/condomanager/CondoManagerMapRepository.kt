package com.adissongomes.condo.db.condomanager

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condomanager.CondoManager
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.Optional
import java.util.UUID

@Repository
class CondoManagerMapRepository : CondoManagerRepository {

    private val data = mutableMapOf<UUID, CondoManager>()

    override fun save(condoManager: CondoManager): CondoManager {
        data[condoManager.id] = condoManager
        return condoManager
    }

    override fun byId(id: UUID): Optional<CondoManager> =
        Optional.ofNullable(data[id])

    override fun associateCondo(condoManager: CondoManager, condo: Condo) {
        byId(condoManager.id).orElseThrow().also {
            val condos = it.condos.toMutableSet()
            condos.add(condo)
            val updatedManager = CondoManager(it.id, it.name, it.document, condos, it.creationDate, Instant.now())
            save(updatedManager)
        }
    }
}
