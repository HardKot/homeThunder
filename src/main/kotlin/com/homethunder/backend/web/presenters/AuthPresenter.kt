package com.homethunder.backend.web.presenters

import com.github.mvysny.kaributools.navigateTo
import com.homethunder.backend.domain.forms.AuthForm
import com.homethunder.backend.domain.interacts.UserInteract
import com.homethunder.backend.security.SecurityService
import com.homethunder.backend.web.views.AuthView
import com.vaadin.flow.data.binder.BeanValidationBinder
import org.springframework.stereotype.Component

@Component
class AuthPresenter(
    private val userInteract: UserInteract,
    private val securityService: SecurityService,
) {
    private val form = AuthForm()
    private val binder = BeanValidationBinder(AuthForm::class.java)
    private lateinit var view: AuthView

    var isLoading = false

    fun submitForm() {
        startLoading()
        binder.writeBean(form)
        val result = securityService.authenticate(form.login!!, form.password!!)
        stopLoading()
        if (result) navigateTo("/")
    }


    fun dropPassword() {

    }

    fun setView(view: AuthView) {
        this.view = view
        binder.apply {
            bind(view.emailField, AuthForm::login.name)
            bind(view.passwordField, AuthForm::password.name)
            bind(view.rememberMeField, AuthForm::rememberMe.name)
        }
    }

    private fun startLoading() = changeLoading(true)

    private fun stopLoading() = changeLoading(false)

    private fun changeLoading(value: Boolean) {
        view.progressBarView.isIndeterminate = value
        view.emailField.isEnabled = !value
        view.passwordField.isEnabled = !value
        view.rememberMeField.isEnabled = !value
        view.submitButton.isEnabled = !value
    }
}
