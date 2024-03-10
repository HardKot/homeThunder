package com.homethunder.backend.domain.interacts

import com.homethunder.backend.domain.entity.User
import com.homethunder.backend.domain.forms.AuthForm
import com.homethunder.backend.domain.forms.ResetPasswordForm
import com.homethunder.backend.domain.forms.UserRegistrationForm
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserInteract(

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
    fun registration(form: UserRegistrationForm): Result<User> {
        TODO()
    }

    sealed class UserInteractErrors : Error() {
        data class ValidationError(override val message: String) :
            UserInteractErrors()

        data class AuthError(override val message: String = "Wrong email or password") : UserInteractErrors()

        data class UserNotFound(override val message: String = "User not found") : UserInteractErrors()
    }
}
