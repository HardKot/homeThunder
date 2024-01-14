package com.homeThunder.data.entity

import com.homeThunder.data.enums.Gender
import com.homeThunder.extensions.now
import com.homeThunder.serializer.UUIDAsStringSerializer
import com.homeThunder.services.PasswordService
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import java.util.*
import javax.inject.Inject

@Serializable
class User @Inject constructor(
    @Serializable(with = UUIDAsStringSerializer::class) override val id: UUID,
    private val state: IUserState
) : IEntity {

    interface IUserState {
        var firstname: String
        var lastname: String
        var patronymic: String?
        var gender: Gender
        var birthday: LocalDate?
        var phone: String?
        var email: String
        var avatarId: UUID?
        var password: ByteArray
        var salt: ByteArray
        val createdAt: LocalDateTime
        val updatedAt: LocalDateTime
    }

    override val createdAt by state::createdAt
    override val updatedAt by state::updatedAt

    val firstName by state::firstname
    val lastName by state::lastname
    val patronymic by state::patronymic
    val gender by state::gender
    val birthday by state::birthday

    val phone by state::phone
    val email by state::email

    fun setFIO(fio: FIO) {
        state.firstname = fio.firstname
        state.lastname = fio.lastname
        state.patronymic = fio.patronymic
    }

    fun setGender(gender: Gender) {
        state.gender = gender
    }

    fun setBirthday(birthday: LocalDate) {
        if (birthday > LocalDate.now()) return
        state.birthday = birthday
    }

    fun setPassword(newPassword: String) {
        state.salt = PasswordService.generateSalt()
        state.password = PasswordService.hashPassword(newPassword, state.salt)
    }

    data class FIO(val firstname: String, val lastname: String, val patronymic: String?)
}
