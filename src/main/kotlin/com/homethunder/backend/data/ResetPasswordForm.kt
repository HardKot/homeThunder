package com.homethunder.backend.data

import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength
import io.konform.validation.jsonschema.pattern

data class ResetPasswordForm(
    override var droppedToken: String?,
    override var password: String?,
    override var confirmPassword: String?
) : IResetPasswordForm, Form<IResetPasswordForm, ResetPasswordForm>() {
    constructor() : this(null,null, null)

    override operator fun <F> set(path: Any, value: F) {
        when (path) {
            ResetPasswordForm::droppedToken -> droppedToken = value as String
            ResetPasswordForm::password -> password = value as String
            ResetPasswordForm::confirmPassword -> confirmPassword = value as String
        }
    }

    override val validationResult
        get() = validation(this)

    override val validation = Validation<ResetPasswordForm> {
        ResetPasswordForm::droppedToken required {}

        ResetPasswordForm::password required {
            minLength(8) hint "Строка должна содержать не менее 8 символов"
            maxLength(100) hint "Строка должна содержать не более 100 символов"
            pattern("^[a-zA-Z\\d%*()?@#\$~{}]+$".toRegex()) hint "Пароль содержит недопустимые символы. Допустимые символы: латинские буквы, цифры, %, *, ?, @, #, $, ~, {, }"
        }

        ResetPasswordForm::confirmPassword required {
//            equals(UserRegistrationForm::password) hint "Пароли не совпадают"
        }
    }
}
