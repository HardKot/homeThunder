package com.homethunder.backend.web.presenters


import com.homethunder.backend.domain.forms.UserRegistrationForm
import com.homethunder.backend.domain.interacts.UserInteract
import com.homethunder.backend.web.views.RegistrationView
import com.vaadin.flow.data.binder.Binder

import org.springframework.stereotype.Component

@Component
class RegistrationPresenter(
    private val userInteract: UserInteract
)  {
    private val form = UserRegistrationForm()
    private val binder = Binder<UserRegistrationForm>()
    private lateinit var view: RegistrationView

    var isLoading = false

    fun submitForm() {
        isLoading = true
        val result = userInteract.registration(form)
//        if (result.isFailure) {
//            val errors = result.exceptionOrNull()
//            if (errors is UserInteract.UserInteractErrors.ValidationError)
//        }
        isLoading = false
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
}
