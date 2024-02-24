package com.homethunder.backend.ui.presenters


import com.homethunder.backend.data.UserRegistrationForm
import com.homethunder.backend.ui.views.RegistrationView
import com.homethunder.backend.useCases.UserInteractor
import kotlinx.datetime.toKotlinLocalDate
import org.springframework.stereotype.Component

@Component
class RegistrationPresenter(
    private val userInteractor: UserInteractor
) {
    lateinit var view: RegistrationView
    val form
        get() = UserRegistrationForm(
            firstname = view.firstnameField.value,
            lastname = view.secondmentField.value,
            patronymic = view.patronymicField.value,
            birthday = view.birthdayField.value.toKotlinLocalDate(),
            gender = view.genderSelector.value,
            email = view.emailField.value,
            password = view.passwordField.value,
            confirmPassword = view.confirmPasswordField.value
        )

    var isLoading = false

    fun submitForm() {
        isLoading = true
        val result = userInteractor.registration(form)
        isLoading = false
    }
}
