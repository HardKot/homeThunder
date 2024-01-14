package com.homeThunder.data.entity

import com.homeThunder.serializer.UUIDAsStringSerializer
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
class Organization(
    @Serializable(with = UUIDAsStringSerializer::class) override val id: UUID,
    private val state: IOrganizationState,
) : IEntity {

    interface IOrganizationState {
        var name: String
        val short: String
        var phone: String?
        var email: String
        val additionalContact: Array<AdditionalContact>
        var avatarId: UUID?
        val createdAt: LocalDateTime
        val updatedAt: LocalDateTime
    }

    val name by state::name
    val short by state::short
    val phone by state::phone
    val email by state::email
    val additionalContact by state::additionalContact
    val avatarId by state::avatarId

    override val createdAt by state::createdAt
    override val updatedAt by state::updatedAt

    @Serializable
    data class AdditionalContact(
        val type: String,
        val value: String,
    )
}
