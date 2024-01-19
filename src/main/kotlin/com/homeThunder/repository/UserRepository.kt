package com.homeThunder.repository

import com.homeThunder.data.entity.User
import com.homeThunder.data.enums.Gender
import kotlinx.datetime.LocalDate
import java.util.*

interface UserRepository {
    suspend fun existsByEmail(email: String): Boolean
    suspend fun existsByPhone(email: String): Boolean

    suspend fun create(userState: IParamsCreateUserState): User.IUserState

    interface IParamsCreateUserState {
        val firstname: String
        val lastname: String
        val patronymic: String?
        val gender: Gender
        val birthday: LocalDate?
        val phone: String?
        val email: String
        val avatarId: UUID?
    }
}
