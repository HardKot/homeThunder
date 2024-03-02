package com.homethunder.backend.ui.presenters

import com.homethunder.backend.data.DropPasswordForm
import com.homethunder.backend.ui.views.DropPasswordView
import com.homethunder.backend.useCases.UserInteract
import org.springframework.stereotype.Component

@Component
class DropPasswordPresenter(
    private val userInteract: UserInteract
) : FormPresenter<DropPasswordForm>(DropPasswordForm::class.java, DropPasswordForm()) {
    lateinit var view: DropPasswordView

    var isLoading = false

    fun submitForm() {
        isLoading = true
        val result = userInteract.dropPassword(form.email!!)
        if (result.isFailure) {
            val errors = result.exceptionOrNull()
            if (errors is UserInteract.UserInteractErrors.ValidationError)
                validate()
        }
        isLoading = false
    }


    fun linkBind() {
        bind(view.emailField, DropPasswordForm::email)
    }
}
