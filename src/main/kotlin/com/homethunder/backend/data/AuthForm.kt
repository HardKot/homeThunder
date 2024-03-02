package com.homethunder.backend.data

import io.konform.validation.Validation

data class AuthForm(
    override var email: String? = null,
    override var password: String? = null,
) : IAuthForm, Form<IAuthForm, AuthForm>() {
    constructor() : this(null, null)

    override operator fun <F> set(path: Any, value: F) {
        when (path) {
            AuthForm::email -> email = value as String
            AuthForm::password -> password = value as String
        }
    }
    override val validationResult
        get() = validation(this)

    override val validation = Validation<AuthForm> {
        AuthForm::email required {}
        AuthForm::password required {}
    }
}
