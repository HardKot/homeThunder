package com.homethunder.backend.domain.forms

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

class DropPasswordForm {
    @NotNull
    @Email
    var email: String? = null
}
