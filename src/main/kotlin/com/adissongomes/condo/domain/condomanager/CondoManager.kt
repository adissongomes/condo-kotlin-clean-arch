package com.adissongomes.condo.domain.condomanager

import com.adissongomes.condo.domain.condo.Condo
import com.adissongomes.condo.domain.condomanager.exception.CondoManagementRestrictionException
import java.time.Instant
import java.util.UUID

class CondoManager(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val document: String,
    val condos: Set<Condo> = setOf(),
    val creationDate: Instant = Instant.now(),
    val lastModifiedDate: Instant = Instant.now(),
) {

    fun validate() {
        require(!name.isBlank()) { "Name cannot be blank" }
        require(!document.isBlank()) { "Document cannot be blank" }
    }

    fun canManage(condo: Condo) {
        if (!condos.contains(condo)) {
            throw CondoManagementRestrictionException("Condo ${condo.name} cannot be managed")
        }
    }

    companion object {
        fun newInstance(name: String, document: String) = CondoManager(name = name, document = document)
    }
}
