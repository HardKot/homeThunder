package com.homeThunder.data.entity

import com.homeThunder.serializer.UUIDAsStringSerializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import java.util.*
import javax.inject.Inject

@Serializable
class Employee @Inject constructor(
    @Serializable(with = UUIDAsStringSerializer::class) override val id: UUID,
    private val state: IEmployeeState,
) : IEntity {

    interface IEmployeeState {
        var firstname: String?
        var lastname: String?
        var patronymic: String?
        var phone: String?
        var email: String?
        var avatarId: UUID?
        var userId: UUID?
        val createdAt: LocalDateTime
        val updatedAt: LocalDateTime
    }

    override val createdAt by state::createdAt
    override val updatedAt by state::updatedAt
}
