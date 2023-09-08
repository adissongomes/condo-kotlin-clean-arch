package com.adissongomes.condo.domain.condo.dto

import com.adissongomes.condo.domain.common.AddressVO
import com.adissongomes.condo.domain.condo.CondoBuilding
import java.util.UUID

data class CondoCreationDTO(
    val name: String,
    val address: AddressVO,
)

data class CondoBuildingCreationDTO(
    val name: String,
    val description: String,
    val floors: Int = 1,
    val zone: String? = null
)

data class CondoDTO(
    val id: UUID,
    val name: String,
    val address: AddressVO,
    val buildings: Set<CondoBuilding>,
)

data class CondoBuildingDTO(
    val id: UUID,
    val name: String,
    val description: String,
    val floors: Int = 1,
    val zone: String? = null
)
