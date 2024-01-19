package com.homeThunder.useCases

import com.homeThunder.data.entity.User
import com.homeThunder.data.enums.Gender
import com.homeThunder.data.factory.UserFactory
import com.homeThunder.database.dao.UserDAO
import com.homeThunder.repository.UserRepository
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable


class UserRegistrationUseCase(
    private val params: Params,
    private val userFactory: UserFactory,
    private val userRepository: UserRepository,
) {
    public suspend fun execute(): User {
        checkUnique()

        val userState = userRepository.create()

        return user
    }

    private suspend fun checkUnique() {
        if (userRepository.existsByEmail(params.email))
            throw Exception("User with email ${params.email} already exists")
        params.phone?.let {
            if (userRepository.existsByPhone(it)) throw Exception("User with phone ${params.phone} already exists")
        }
    }


    data class Params(
        val firstname: String,
        val lastname: String,
        val patronymic: String?,
        val gender: Gender,
        val birthday: LocalDate?,

        val phone: String?,
        val email: String,

        val password: String,
    )
}
