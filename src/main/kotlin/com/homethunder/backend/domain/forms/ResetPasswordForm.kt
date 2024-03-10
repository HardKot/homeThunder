package com.homethunder.backend.domain.forms

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

class ResetPasswordForm {
    @NotNull
    var droppedToken: String? = null


    @NotNull
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\d%*()?@#\$~{}]+$")
    var password: String? = null


    @NotNull
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\d%*()?@#\$~{}]+$")
    var confirmPassword: String? = null
}
