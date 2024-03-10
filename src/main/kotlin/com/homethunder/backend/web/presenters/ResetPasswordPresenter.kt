package com.homethunder.backend.web.presenters

import com.homethunder.backend.domain.interacts.UserInteract
import com.homethunder.backend.web.views.ResetPasswordView
import org.springframework.stereotype.Component

@Component
class ResetPasswordPresenter(
    private val userInteract: UserInteract
) {
    lateinit var view: ResetPasswordView

    var isLoading = false

    fun submitForm() {
        isLoading = true
//        val result = userInteract.resetPassword(form)
//        if (result.isFailure) {
//            val errors = result.exceptionOrNull()
//            if (errors is UserInteract.UserInteractErrors.ValidationError)
//                validate()
//        }
        isLoading = false
    }


    fun linkBind() {
//        bind(view.passwordField, ResetPasswordForm::password)
//        bind(view.confirmPasswordField, ResetPasswordForm::confirmPassword)
    }
}
