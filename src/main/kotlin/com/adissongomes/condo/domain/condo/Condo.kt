package com.adissongomes.condo.domain.condo

import com.adissongomes.condo.domain.common.AddressVO
import java.util.UUID

class Condo(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val address: AddressVO,
    val buildings: List<CondoBuilding> = listOf()
) {

    fun validate() {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }

    fun getBuilding(buildingId: UUID): CondoBuilding {
        return buildings.first { it.id == buildingId }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Condo

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

class CondoBuilding(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val floors: Int = 1,
    val zone: String? = null
) {
    fun validate() {
        require(floors > 0) { "The building should have at least one floor" }
        require(name.isNotBlank()) { "The name cannot be blank" }
        require(description.isNotBlank()) { "The description cannot be blank" }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CondoBuilding

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}
