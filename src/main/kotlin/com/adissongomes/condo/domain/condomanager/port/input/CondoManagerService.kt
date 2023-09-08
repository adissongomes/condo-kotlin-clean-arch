package com.adissongomes.condo.domain.condomanager.port.input

import com.adissongomes.condo.domain.condomanager.dto.CondoManagerCreationDTO
import com.adissongomes.condo.domain.condomanager.dto.CondoManagerDTO
import java.util.UUID

interface CondoManagerService {
    fun create(condoManagerCreationDTO: CondoManagerCreationDTO): CondoManagerDTO
    fun fetchById(id: UUID): CondoManagerDTO
}
