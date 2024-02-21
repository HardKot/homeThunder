package com.homethunder.backend.ui.presenters

import com.vaadin.flow.component.button.Button
import com.homethunder.backend.ui.Presenter
import com.homethunder.backend.ui.models.RegistrationModel
import com.homethunder.backend.ui.views.RegistrationView

class RegistrationPresenter(view: RegistrationView) : Presenter(RegistrationModel(view)) {
    val model = RegistrationModel(view)


//вариант -----
    // val firstname = view.firstnameField::value
    // val secondname = view.secondnameField::value
    // val patronymic = view.patronymicField::value

    // val birthday = view.birthdayField::value 
    
    // val gender = view.genderSelector::value
    // val email = view.emailField::value
    
    // val password = view.passwordField::value
    // val confirmPassword = view.confirmPassword::value
    //------
    
    
}
