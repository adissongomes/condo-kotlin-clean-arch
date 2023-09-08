package com.adissongomes.condo.domain.condomanager.dto

import com.adissongomes.condo.domain.condomanager.CondoManager
import java.time.Instant
import java.util.UUID

data class CondoManagerCreationDTO(val name: String, val document: String)
data class CondoManagerDTO(val id: UUID, val name: String, val document: String, val createdDate: Instant, val lastModifiedDate: Instant)

fun CondoManagerCreationDTO.toDomain(): CondoManager = CondoManager.newInstance(name, document)

fun CondoManager.toDTO(): CondoManagerDTO = CondoManagerDTO(id, name, document, creationDate, lastModifiedDate)
