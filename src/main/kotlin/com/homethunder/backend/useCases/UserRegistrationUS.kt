package com.homethunder.backend.useCases

import com.homethunder.backend.data.UserRegistrationForm
import com.homethunder.backend.domain.enums.Gender
import com.homethunder.backend.extensions.before
import com.homethunder.backend.extensions.today
import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength
import io.konform.validation.jsonschema.pattern
import kotlinx.datetime.LocalDate
import org.springframework.stereotype.Component

@Component
object UserRegistrationUS {

    fun execute(form: UserRegistrationForm) {
        println(form.toString())
    }



    val UserRegistrationFormValidate = Validation<UserRegistrationForm> {
        UserRegistrationForm::firstName required {
            pattern("^[a-zA-Zа-яА-Я\\-\\.\\'\\,\\(\\)\\ ]+$".toRegex())
        }

        UserRegistrationForm::lastName required {
            pattern("^[a-zA-Zа-яА-Я\\-\\.\\'\\,\\(\\)\\ ]+$".toRegex())
        }

        UserRegistrationForm::email required {
            pattern("^[\\w\\d!\$&*\\-=^`|~#%'+\\/?_{}\"\\@\\\\]+@[\\w\\d]+\\.[\\w\\d]+$".toRegex())
        }

        UserRegistrationForm::patronymic ifPresent {
            pattern("^[a-zA-Zа-яА-Я\\-\\.\\'\\,\\(\\)\\ ]+$".toRegex())
        }

        UserRegistrationForm::birthday ifPresent {
            before(LocalDate.today())
        }

        UserRegistrationForm::password required {
            minLength(8)
            maxLength(100)
                pattern("^[a-zA-Z\\d%*\\()?@#\$~\\{}]+$".toRegex())
        }

    }
}
