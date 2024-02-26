package com.homethunder.backend.ui.presenters


import com.homethunder.backend.data.UserRegistrationForm
import com.homethunder.backend.ui.views.RegistrationView
import com.homethunder.backend.useCases.UserInteract
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toKotlinLocalDate
import org.springframework.stereotype.Component

@Component
class RegistrationPresenter(
    private val userInteract: UserInteract
) : FormPresenter<UserRegistrationForm>(UserRegistrationForm::class.java, UserRegistrationForm()) {
    lateinit var view: RegistrationView

    var isLoading = false

    fun submitForm() {
        isLoading = true
        val validateStatus = validate()

        val result = userInteract.registration(form)
        isLoading = false
    }


    fun linkBind() {
        bind(view.firstnameField, UserRegistrationForm::firstname)
        bind(view.lastnameField, UserRegistrationForm::lastname)
        bind(view.patronymicField, UserRegistrationForm::patronymic)

        bind(view.genderSelector, UserRegistrationForm::gender)
        bind(view.birthdayField, UserRegistrationForm::birthday) {
            withConverter({ it.toKotlinLocalDate() }, { it.toJavaLocalDate() })
        }

        bind(view.emailField, UserRegistrationForm::email)
        bind(view.passwordField, UserRegistrationForm::password)
        bind(view.confirmPasswordField, UserRegistrationForm::confirmPassword)
    }
}
