package com.homethunder.backend.data

import com.homethunder.backend.domain.enums.Gender
import kotlinx.datetime.LocalDate

data class UserRegistrationForm(
    val firstname: String,
    val lastname: String,
    val patronymic: String?,
    val birthday: LocalDate?,
    val gender: Gender?,
    val email: String,
    val password: String,
)
