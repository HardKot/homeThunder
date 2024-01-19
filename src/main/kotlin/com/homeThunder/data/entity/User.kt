package com.homeThunder.data.entity

import com.homeThunder.data.enums.Gender
import kotlinx.datetime.LocalDate
import java.util.*

class User constructor(
    val id: UUID,
    private val state: IUserState
) {
    val firstName by state::firstname
    val lastName by state::lastname
    val patronymic by state::patronymic

    val gender by state::gender
    val birthday by state::birthday

    val phone by state::phone
    val email by state::email

    val avatarId by state::avatarId

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
        val passwordSalt: ByteArray
    }
}
