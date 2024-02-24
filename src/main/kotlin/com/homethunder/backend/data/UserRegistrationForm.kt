package com.homethunder.backend.data

import com.homethunder.backend.domain.enums.Gender
import com.homethunder.backend.extensions.before
import com.homethunder.backend.extensions.today
import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength
import io.konform.validation.jsonschema.pattern
import kotlinx.datetime.LocalDate

class UserRegistrationForm(
    val firstname: String,
    val lastname: String,
    val patronymic: String?,
    val birthday: LocalDate?,
    val gender: Gender,
    val email: String,
    val password: String,
    val confirmPassword: String,
) {
    private val validateResult = Validation<UserRegistrationForm> {
        run(validateFirstName)
        run(validateLastname)
        run(validateEmail)
        run(validatePatronymic)
        run(validateBirthday)
        run(validatePassword)
        run(validateConfirmPassword)
    } .validate(this)

    val errors = validateResult.errors
    companion object {
        val validateFirstName = Validation<UserRegistrationForm> {
            UserRegistrationForm::firstname required {
                pattern("^[а-яА-Я\\-.',() ]+$".toRegex())
            }
        }

        val validateLastname = Validation<UserRegistrationForm> {
            UserRegistrationForm::lastname required {
                pattern("^[а-яА-Я\\-.',() ]+$".toRegex())
            }
        }

        val validatePatronymic = Validation<UserRegistrationForm> {
            UserRegistrationForm::patronymic ifPresent {
                pattern("^[а-яА-Я\\-\\.\\'\\,\\(\\)\\ ]+$".toRegex())
            }
        }

        val validateEmail = Validation<UserRegistrationForm> {
            UserRegistrationForm::email required {
                pattern("^[\\w\\d!\$&*\\-=^`|~#%'+\\/?_{}\"\\@\\\\]+@[\\w\\d]+\\.[\\w\\d]+$".toRegex())
//                unique(UserRepository()::emailExists)
            }
        }

        val validateBirthday = Validation<UserRegistrationForm> {
            UserRegistrationForm::birthday ifPresent {
                before(LocalDate.today())
            }
        }

        val validatePassword = Validation<UserRegistrationForm> {
            UserRegistrationForm::password required {
                minLength(8)
                maxLength(100)
                pattern("^[a-zA-Z\\d%*\\()?@#\$~\\{}]+$".toRegex())
            }
        }

        val validateConfirmPassword = Validation<UserRegistrationForm> {
            UserRegistrationForm::confirmPassword required {
                equals(UserRegistrationForm::password)
            }
        }
    }
}
