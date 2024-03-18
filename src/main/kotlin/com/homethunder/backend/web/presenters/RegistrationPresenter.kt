package com.homethunder.backend.web.presenters


import com.github.mvysny.kaributools.navigateTo
import com.homethunder.backend.domain.forms.UserRegistrationForm
import com.homethunder.backend.domain.interacts.UserInteract
import com.homethunder.backend.security.SecurityService
import com.homethunder.backend.web.views.RegistrationView
import com.vaadin.flow.data.binder.BeanValidationBinder

import org.springframework.stereotype.Component


@Component
class RegistrationPresenter(
    private val userInteract: UserInteract,
    private val securityService: SecurityService,
)  {
    private val binder = BeanValidationBinder(UserRegistrationForm::class.java)
    private lateinit var view: RegistrationView
    private val form = UserRegistrationForm()

    fun bind() {
        binder.bindInstanceFields(this)
    }



    fun submitForm() {
        startLoading()
        binder.writeBean(form)
        val result = userInteract.registration(form)
        if (result.isSuccess) {
            securityService.authenticate(form.email!!, form.password!!)
        }
        stopLoading()

        navigateTo("/")
    }


    fun setView(view: RegistrationView) {
        this.view = view
        binder.apply {
            bind(view.firstnameField, UserRegistrationForm::firstname.name)
            bind(view.lastnameField, UserRegistrationForm::lastname.name)
            bind(view.patronymicField, UserRegistrationForm::patronymic.name)

            bind(view.genderSelector, UserRegistrationForm::gender.name)
            bind(view.birthdayField, UserRegistrationForm::birthday.name)

            bind(view.emailField, UserRegistrationForm::email.name)
            bind(view.passwordField, UserRegistrationForm::password.name)
            bind(view.confirmPasswordField, UserRegistrationForm::confirmPassword.name)
        }
    }

    private fun startLoading() = changeLoading(true)

    private fun stopLoading() = changeLoading(false)

    private fun changeLoading(value: Boolean) {
        view.progressBarView.isIndeterminate = value
        view.firstnameField.isEnabled = !value
        view.lastnameField.isEnabled = !value
        view.patronymicField.isEnabled = !value
        view.genderSelector.isEnabled = !value
        view.birthdayField.isEnabled = !value
        view.emailField.isEnabled = !value
        view.passwordField.isEnabled = !value
        view.confirmPasswordField.isEnabled = !value
        view.submitButton.isEnabled = !value
    }

}
