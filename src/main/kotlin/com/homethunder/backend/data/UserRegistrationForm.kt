package com.homethunder.backend.data

import com.homethunder.backend.domain.enums.Gender
import com.homethunder.backend.extensions.before
import com.homethunder.backend.extensions.today
import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength
import io.konform.validation.jsonschema.pattern
import kotlinx.datetime.LocalDate

data class UserRegistrationForm(
    override var firstname: String?,
    override var lastname: String?,
    override var patronymic: String?,
    override var birthday: LocalDate?,
    override var gender: Gender?,
    override var email: String?,
    override var password: String?,
    override var confirmPassword: String?,
) : IUserRegistrationForm, Form<IUserRegistrationForm, UserRegistrationForm>() {
    constructor() : this(null, null, null, null, null, null, null, null)

    override val validationResult
        get() = validation(this)

    override operator fun <F> set(path: Any, value: F) {
        when (path) {
            UserRegistrationForm::firstname -> firstname = value as String
            UserRegistrationForm::lastname -> lastname = value as String
            UserRegistrationForm::patronymic -> patronymic = value as String
            UserRegistrationForm::birthday -> birthday = value as LocalDate?
            UserRegistrationForm::gender -> gender = value as Gender?
            UserRegistrationForm::email -> email = value as String
            UserRegistrationForm::password -> password = value as String
            UserRegistrationForm::confirmPassword -> confirmPassword = value as String
        }
    }

    override val validation = Validation<UserRegistrationForm> {
        UserRegistrationForm::firstname required {}

        UserRegistrationForm::lastname required {}

        UserRegistrationForm::patronymic ifPresent {}

        UserRegistrationForm::email required {
            pattern("^[a-zA-Z\\d-.]+@([a-zA-Z\\d-]+\\.)+[a-zA-Z\\d-]{2,4}\$".toRegex()) hint "Некорректная почта, попробуйте другую"
        }

        UserRegistrationForm::gender ifPresent {}

        UserRegistrationForm::birthday ifPresent {
            before(LocalDate.today()) hint "Не корректно указан день рождения"
        }

        UserRegistrationForm::password required {
            minLength(8) hint "Строка должна содержать не менее 8 символов"
            maxLength(100) hint "Строка должна содержать не более 100 символов"
            pattern("^[a-zA-Z\\d%*()?@#\$~{}]+$".toRegex()) hint "Пароль содержит недопустимые символы. Допустимые символы: латинские буквы, цифры, %, *, ?, @, #, $, ~, {, }"
        }

        UserRegistrationForm::confirmPassword required {
//            equals(UserRegistrationForm::password) hint "Пароли не совпадают"
        }
    }
}

