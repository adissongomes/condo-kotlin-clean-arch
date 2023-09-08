package com.adissongomes.condo.data.condomanager

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condomanager.CondoManager
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import org.springframework.stereotype.Repository
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
            it.addCondo(condo.id)
            save(it) // unnecessary because the changes are applied to the reference already
        }
    }
}
