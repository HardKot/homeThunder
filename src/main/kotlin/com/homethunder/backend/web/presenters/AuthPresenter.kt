package com.homethunder.backend.web.presenters

import com.homethunder.backend.domain.forms.AuthForm
import com.homethunder.backend.domain.interacts.UserInteract
import com.homethunder.backend.web.views.AuthView
import org.springframework.stereotype.Component

@Component
class AuthPresenter(
    private val userInteract: UserInteract
) {

    lateinit var view: AuthView

    var isLoading = false

    fun submitForm() {
        isLoading = true

        isLoading = false
    }

    fun linkBind() {

    }

    fun dropPassword() {

    }
}
