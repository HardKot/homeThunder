package com.homethunder.backend.domain.interacts

import com.homethunder.backend.domain.entity.User
import com.homethunder.backend.domain.forms.AuthForm
import com.homethunder.backend.domain.forms.ResetPasswordForm
import com.homethunder.backend.domain.forms.UserRegistrationForm
import com.homethunder.backend.repository.UserRepository
import jakarta.validation.Valid
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserInteract(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder,
) {
    @Transactional
    fun login(form: AuthForm): Result<User> {
        TODO()
    }

    @Transactional
    fun dropPassword(email: String) {
        TODO()
    }

    @Transactional
    fun resetPassword(form: ResetPasswordForm): Result<User> {
        TODO()
    }

    @Transactional
    fun registration(@Valid form: UserRegistrationForm): Result<User> {
        if (form.password != form.confirmPassword) {
            return Result.failure(UserInteractErrors.ValidationError("Passwords don't match"))
        }

        val entity = User(
            firstname = form.firstname!!,
            lastname = form.lastname!!,
            patronymic = form.patronymic,
            birthday = form.birthday!!,
            gender = form.gender!!,
            email = form.email!!,
            password = passwordEncoder.encode(form.password!!),
        )
        userRepository.save(entity)

        return Result.success(entity)
    }

    sealed class UserInteractErrors : Error() {
        data class ValidationError(override val message: String) :
            UserInteractErrors()

        data class AuthError(override val message: String = "Wrong email or password") : UserInteractErrors()

        data class UserNotFound(override val message: String = "User not found") : UserInteractErrors()
    }
}
