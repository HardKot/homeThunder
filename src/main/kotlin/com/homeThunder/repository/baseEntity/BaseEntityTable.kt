package com.homeThunder.repository.baseEntity

import com.homeThunder.repository.columns.createAt
import com.homeThunder.repository.columns.updateAt
import org.jetbrains.exposed.dao.id.UUIDTable

abstract class BaseEntityTable(name: String) : UUIDTable(name) {
    val createdAt = createAt()
    val updatedAt = updateAt()
}
