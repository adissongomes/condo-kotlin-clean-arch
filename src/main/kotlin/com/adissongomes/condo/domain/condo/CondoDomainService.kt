package com.adissongomes.condo.domain.condo

import com.adissongomes.condo.domain.condomanager.CondoManager
import java.util.UUID

interface CondoDomainService {
    fun addBuilding(condo: Condo, condoManager: CondoManager, building: CondoBuilding): Condo
    fun removeBuilding(condo: Condo, condoManager: CondoManager, building: UUID): Condo
}
