package com.homethunder.backend.data

import com.homethunder.backend.domain.enums.Gender
import kotlinx.datetime.LocalDate

interface IUserRegistrationForm {
    var firstname: String?
    var lastname: String?
    var patronymic: String?
    var birthday: LocalDate?
    var gender: Gender?
    var email: String?
    var password: String?
    var confirmPassword: String?
}
