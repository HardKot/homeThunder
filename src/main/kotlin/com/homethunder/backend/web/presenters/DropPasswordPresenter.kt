package com.homethunder.backend.web.presenters

import com.homethunder.backend.domain.interacts.UserInteract
import com.homethunder.backend.web.views.DropPasswordView
import org.springframework.stereotype.Component

@Component
class DropPasswordPresenter(
    private val userInteract: UserInteract
) {
    lateinit var view: DropPasswordView

    var isLoading = false

    fun submitForm() {
        isLoading = true
//        val result = userInteract.dropPassword(form.email!!)
//        if (result.isFailure) {
//            val errors = result.exceptionOrNull()
//            if (errors is UserInteract.UserInteractErrors.ValidationError)
//                validate()
//        }
        isLoading = false
    }


    fun linkBind() {
//        bind(view.emailField, DropPasswordForm::email)
    }
}
