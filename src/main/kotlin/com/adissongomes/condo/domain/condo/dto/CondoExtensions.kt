package com.adissongomes.condo.domain.condo.dto

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condo.CondoBuilding

fun CondoCreationDTO.toDomain() = Condo(name = name, address = address)

fun Condo.toDTO() = CondoDTO(id, name, address, buildings)

fun CondoBuildingCreationDTO.toDomain() =
    CondoBuilding(
        name = name,
        description = description,
        floors = floors,
        zone = zone
    )

fun CondoBuilding.toDTO() = CondoBuildingDTO(id, name, description, floors, zone)