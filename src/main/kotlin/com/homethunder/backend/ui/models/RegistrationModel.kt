package com.homethunder.backend.ui.models

import com.github.mvysny.karibudsl.v10.KComposite
import com.homethunder.backend.domain.enums.Gender
import kotlinx.datetime.LocalDate
import com.homethunder.backend.ui.Model

class RegistrationModel(view: KComposite) : Model(view) {
    val firstname = view.firstnameField::value
    val secondname = view.secondnameField::value
    val patronymic = view.patronymicField::value

    val birthday = view.birthdayField::value 
    
    val gender = view.genderSelector::value
    val email = view.emailField::value
    
    val password = view.passwordField::value
    val confirmPassword = view.confirmPassword::value
    
    val isLoading = false
    
    fun submitForm() {
        isLoading = true
        val result = UserRegistrationUS().exec(this)
        isLoading = false
    }
}
