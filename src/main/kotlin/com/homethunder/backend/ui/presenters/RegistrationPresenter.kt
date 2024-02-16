package com.homethunder.backend.ui.presenters

import com.vaadin.flow.component.button.Button
import com.homethunder.backend.ui.Presenter
import com.homethunder.backend.ui.models.RegistrationModel
import com.homethunder.backend.ui.views.RegistrationView

class RegistrationPresenter(view: RegistrationView) : Presenter(RegistrationModel(view)) {


    lateinit var submitRegistation: Button
}
