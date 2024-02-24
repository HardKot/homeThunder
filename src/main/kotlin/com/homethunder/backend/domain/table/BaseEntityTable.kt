package com.homethunder.backend.domain.table

import com.homethunder.backend.extensions.now
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

abstract class BaseEntityTable(name: String) : UUIDTable(name) {
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").default(LocalDateTime.now())
}
