package com.adissongomes.condo.domain.condo

import com.adissongomes.condo.domain.condo.port.input.CondoDomainService
import com.adissongomes.condo.domain.condomanager.CondoManager
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CondoDomainServiceImpl : CondoDomainService {
    override fun addBuilding(condo: Condo, condoManager: CondoManager, building: CondoBuilding): Condo {
        building.validate()
        condoManager.canManage(condo.id)
        condo.addBuilding(building)
        return condo
    }

    override fun removeBuilding(condo: Condo, condoManager: CondoManager, building: UUID): Condo {
        condoManager.canManage(condo.id)
        condo.removeBuilding(building)
        return condo
    }
}
