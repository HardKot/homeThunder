package com.homethunder.backend.domain.forms

import com.homethunder.backend.domain.enums.Gender
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.time.LocalDate

class UserRegistrationForm {
    @NotNull
    var firstname: String? = null

    @NotNull
    var lastname: String? = null

    var patronymic: String? = null

    @Past
    var birthday: LocalDate? = null

    var gender: Gender? = null

    @NotNull
    @Email
    var email: String? = null

    @NotNull
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\d%*()?@#\$~{}]+$")
    var password: String? = null

    @NotNull
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\d%*()?@#\$~{}]+$")
    var confirmPassword: String? = null
}
