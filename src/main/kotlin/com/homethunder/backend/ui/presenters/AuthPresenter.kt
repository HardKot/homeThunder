package com.homethunder.backend.ui.presenters

import com.homethunder.backend.data.AuthForm
import com.homethunder.backend.ui.views.AuthView
import com.homethunder.backend.useCases.UserInteract
import org.springframework.stereotype.Component

@Component
class AuthPresenter(
    private val userInteract: UserInteract
) : FormPresenter<AuthForm>(AuthForm::class.java, AuthForm()) {

    lateinit var view: AuthView

    var isLoading = false

    fun submitForm() {
        isLoading = true
        val result = userInteract.login(form)
        if (result.isFailure) {
            val errors = result.exceptionOrNull()
            if (errors is UserInteract.UserInteractErrors.ValidationError)
                validate()
        }
        isLoading = false
    }

    fun linkBind() {
        bind(view.emailField, AuthForm::email)
        bind(view.passwordField, AuthForm::password)
    }
}
