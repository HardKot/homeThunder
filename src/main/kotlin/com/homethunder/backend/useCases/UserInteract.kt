package com.homethunder.backend.useCases

import com.homethunder.backend.data.AuthForm
import com.homethunder.backend.data.DropPasswordForm
import com.homethunder.backend.data.ResetPasswordForm
import com.homethunder.backend.data.UserRegistrationForm
import com.homethunder.backend.domain.entity.User
import com.homethunder.backend.domain.enums.Gender
import com.homethunder.backend.domain.table.UsersTable
import com.homethunder.backend.services.JWTService
import com.homethunder.backend.services.PasswordService
import io.konform.validation.ValidationErrors
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserInteract(
    private val passwordService: PasswordService,
    private val jwtService: JWTService,
) {
    @Transactional
    fun login(form: AuthForm): Result<User> {
        try {
            if (form.errors.isNotEmpty()) return Result.failure(
                UserInteractErrors.ValidationError(
                    "Error Validate",
                    form.errors
                )
            )
            val user = User.find { UsersTable.email eq form.email!! }.firstOrNull()
            if (user == null) return Result.failure(
                UserInteractErrors.AuthError(
                    "Wrong email or password"
                )
            )
            if (!passwordService.isExpectedPassword(form.password!!, user.password, user.passwordSalt)) return Result.failure(
                UserInteractErrors.AuthError(
                    "Wrong email or password"
                )
            )
            return Result.success(user)
        } catch (error: Error) {
            return Result.failure(error)
        }
    }

    @Transactional
    fun dropPassword(email: String) {
        try {
            val user = User.find { UsersTable.email eq email }.firstOrNull()
            if (user == null) return

            val token = jwtService.generateUserIdToken(user.id.value)
            println("Токен восстановления $token")

        } catch (_: Error) {
        }
    }

    @Transactional
    fun resetPassword(form: ResetPasswordForm): Result<User> {
        try {
            if (form.errors.isNotEmpty()) return Result.failure(
                UserInteractErrors.ValidationError(
                    "Error Validate",
                    form.errors
                )
            )
            val userId = jwtService.getUserIdToken(form.droppedToken!!)
            val user = User.findById(userId) ?: return Result.failure(UserInteractErrors.UserNotFound())

            return Result.success(user.apply {
                passwordSalt = passwordService.generateSalt()
                password = passwordService.hashPassword(form.password!!, user.passwordSalt)
            })

        } catch (error: Error) {
            return Result.failure(error)
        }
    }

    @Transactional
    fun registration(form: UserRegistrationForm): Result<User> {
        try {
            if (form.errors.isNotEmpty()) return Result.failure(
                UserInteractErrors.ValidationError(
                    "Error Validate",
                    form.errors
                )
            )

            return Result.success(User.new {
                firstname = form.firstname!!
                lastname = form.lastname!!
                patronymic = form.patronymic!!
                gender = Gender.Male
                birthday = form.birthday!!
                email = form.email!!
                passwordSalt = passwordService.generateSalt()
                password = passwordService.hashPassword(form.password!!, passwordSalt)
            })
        } catch (e: Error) {
            return Result.failure(e)
        }
    }

    sealed class UserInteractErrors : Error() {
        data class ValidationError(override val message: String, val validationErrors: ValidationErrors) :
            UserInteractErrors()

        data class AuthError(override val message: String = "Wrong email or password") : UserInteractErrors()

        data class UserNotFound(override val message: String = "User not found") : UserInteractErrors()
    }
}
