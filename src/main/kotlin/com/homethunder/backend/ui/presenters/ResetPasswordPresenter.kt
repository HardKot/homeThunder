package com.homethunder.backend.ui.presenters

import com.homethunder.backend.data.ResetPasswordForm
import com.homethunder.backend.ui.views.ResetPasswordView
import com.homethunder.backend.useCases.UserInteract
import org.springframework.stereotype.Component

@Component
class ResetPasswordPresenter(
    private val userInteract: UserInteract
) : FormPresenter<ResetPasswordForm>(ResetPasswordForm::class.java, ResetPasswordForm()) {
    lateinit var view: ResetPasswordView

    var isLoading = false

    fun submitForm() {
        isLoading = true
        val result = userInteract.resetPassword(form)
        if (result.isFailure) {
            val errors = result.exceptionOrNull()
            if (errors is UserInteract.UserInteractErrors.ValidationError)
                validate()
        }
        isLoading = false
    }


    fun linkBind() {
        bind(view.passwordField, ResetPasswordForm::password)
        bind(view.confirmPasswordField, ResetPasswordForm::confirmPassword)
    }
}
