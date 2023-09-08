package com.adissongomes.condo.domain.condomanager

import com.adissongomes.condo.domain.condomanager.exception.CondoManagementRestrictionException
import java.time.Instant
import java.util.UUID

class CondoManager(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val document: String,
    val creationDate: Instant = Instant.now(),
    val lastModifiedDate: Instant = Instant.now(),
    private val condoSet: MutableSet<UUID> = mutableSetOf(),
) {

    val condos get() = condoSet.toList()

    fun validate() {
        require(!name.isBlank()) { "Name cannot be blank" }
        require(!document.isBlank()) { "Document cannot be blank" }
    }

    fun addCondo(condoId: UUID) {
        condoSet.add(condoId)
    }

    fun removeCondo(condoId: UUID) {
        condoSet.remove(condoId)
    }

    fun canManage(condoId: UUID) {
        if (!condoSet.contains(condoId)) {
            throw CondoManagementRestrictionException("Condo $condoId cannot be managed")
        }
    }

    companion object {
        fun newInstance(name: String, document: String) = CondoManager(name = name, document = document)
    }
}
