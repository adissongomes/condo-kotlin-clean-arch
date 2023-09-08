package com.adissongomes.condo.domain.condomanager.port.output

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condomanager.CondoManager
import java.util.Optional
import java.util.UUID

interface CondoManagerRepository {
    fun save(condoManager: CondoManager): CondoManager
    fun byId(id: UUID): Optional<CondoManager>
    fun associateCondo(condoManager: CondoManager, condo: Condo)
}