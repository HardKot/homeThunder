package com.homeThunder.data.entity

import kotlinx.datetime.LocalDateTime
import java.util.UUID

interface IEntity {
    val id: UUID
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime
}
