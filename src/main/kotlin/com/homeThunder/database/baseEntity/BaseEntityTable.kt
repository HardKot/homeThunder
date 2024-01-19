package com.homeThunder.database.baseEntity

import com.homeThunder.database.columns.createAt
import com.homeThunder.database.columns.updateAt
import org.jetbrains.exposed.dao.id.UUIDTable

abstract class BaseEntityTable(name: String) : UUIDTable(name) {
    val createdAt = createAt()
    val updatedAt = updateAt()
}
