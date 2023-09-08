package com.adissongomes.condo.domain.common

data class AddressVO(
    val street: String,
    val number: String,
    val complement: String? = null,
    val zipcode: String? = null,
    val reference: String? = null,
)

data class BuildingReference(
    val building: String,
    val floor: String,
)