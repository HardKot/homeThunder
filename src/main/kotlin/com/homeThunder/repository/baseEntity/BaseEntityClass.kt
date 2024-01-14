package com.homeThunder.repository.baseEntity

import com.homeThunder.extensions.now
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.SqlExpressionBuilder

abstract class BaseEntityClass<E : BaseEntity>(table: BaseEntityTable) : UUIDEntityClass<E>(table) {
    init {
        EntityHook.subscribe { action ->
            if (action.changeType == EntityChangeType.Updated) {
                try {
                    action.toEntity(this)?.updatedAt = LocalDateTime.now()
                } catch (error: Exception) {
                    error.printStackTrace()
                }

            }
        }
    }

    fun findOne(op: SqlExpressionBuilder.() -> Op<Boolean>) = find(op).limit(1)

}
