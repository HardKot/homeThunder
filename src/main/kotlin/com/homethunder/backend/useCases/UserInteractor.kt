package com.homethunder.backend.useCases

import com.homethunder.backend.data.UserRegistrationForm
import com.homethunder.backend.domain.entity.User
import com.homethunder.backend.services.PasswordService
import io.konform.validation.ValidationErrors
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserInteractor(
    private val passwordService: PasswordService
) {

    @Transactional
    fun registration(form: UserRegistrationForm): Result<User> {
        try {
            if (form.errors.isEmpty()) return Result.failure(
                UserInteractorErrors.ValidationError(
                    "Error Validate",
                    form.errors
                )
            )
            if (form.password != form.confirmPassword) return Result.failure(UserInteractorErrors.PasswordNotMatch())


            return Result.success(User.new {
                firstname = form.firstname
                lastname = form.lastname
                patronymic = form.patronymic
                gender = form.gender
                birthday = form.birthday
                email = form.email
                password = passwordService.generateSalt()
                passwordSalt = passwordService.hashPassword(form.password, passwordSalt)
            })
        } catch (e: Error) {
            return Result.failure(e)
        }
    }

    sealed class UserInteractorErrors : Error() {
        data class ValidationError(override val message: String, val validationErrors: ValidationErrors) :
            UserInteractorErrors()

        class PasswordNotMatch : UserInteractorErrors() {
            override val message: String = "The password does not match"
        }

        class EmailAlreadyExists : UserInteractorErrors() {
            override val message: String = "Email already exists"
        }
    }
}
