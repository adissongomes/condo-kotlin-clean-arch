package com.adissongomes.condo.domain.condo.port.input

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condo.CondoBuilding
import com.adissongomes.condo.domain.condomanager.CondoManager
import java.util.UUID

interface CondoDomainService {
    fun addBuilding(condo: Condo, condoManager: CondoManager, building: CondoBuilding): Condo
    fun removeBuilding(condo: Condo, condoManager: CondoManager, building: UUID): Condo
}
