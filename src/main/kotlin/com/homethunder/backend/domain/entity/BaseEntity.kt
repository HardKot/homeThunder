package com.homethunder.backend.domain.entity

import com.homethunder.backend.domain.table.BaseEntityTable
import com.homethunder.backend.extensions.now
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

abstract class BaseEntity(id: EntityID<UUID>, table: BaseEntityTable) : UUIDEntity(id) {
    val createdAt by table.createdAt
    var updatedAt by table.updatedAt
}


abstract class BaseEntityClass<E : BaseEntity>(table: BaseEntityTable) : UUIDEntityClass<E>(table) {
    init {
        EntityHook.subscribe { action ->
            if (action.changeType == EntityChangeType.Updated) {
                try {
                    action.toEntity(this)?.updatedAt = LocalDateTime.now()
                } catch (_: Exception) {
                }

            }
        }
    }
}
