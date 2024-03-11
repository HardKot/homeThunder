package com.homethunder.backend.domain.forms

import com.homethunder.backend.domain.enums.Gender
import jakarta.validation.constraints.*
import java.time.LocalDate

class UserRegistrationForm {
    @NotEmpty
    var firstname: String? = null

    @NotEmpty
    var lastname: String? = null

    var patronymic: String? = null

    @NotNull
    @Past
    var birthday: LocalDate? = null

    var gender: Gender? = null

    @NotEmpty
    @Email
    var email: String? = null

    @NotEmpty
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\d%*()?@#\$~{}]+$")
    var password: String? = null

    @NotEmpty
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\d%*()?@#\$~{}]+$")
    var confirmPassword: String? = null
}
