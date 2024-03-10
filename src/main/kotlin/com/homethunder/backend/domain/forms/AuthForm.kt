package com.homethunder.backend.domain.forms

import jakarta.validation.constraints.NotNull

class AuthForm {
    @NotNull
    var login: String? = null
    @NotNull
    var password: String? = null
}
