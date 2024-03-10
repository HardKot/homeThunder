package com.homethunder.backend.web.views

import com.github.mvysny.karibudsl.v10.button
import com.github.mvysny.karibudsl.v10.passwordField
import com.github.mvysny.karibudsl.v10.verticalLayout
import com.homethunder.backend.web.presenters.ResetPasswordPresenter
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.textfield.PasswordField
import com.vaadin.flow.router.BeforeEvent
import com.vaadin.flow.router.HasUrlParameter
import com.vaadin.flow.router.Route
import jakarta.annotation.PostConstruct

@Route("/resetPassword")
class ResetPasswordView(
    private val presenter: ResetPasswordPresenter
) : FormLayout(), HasUrlParameter<String> {
    lateinit var passwordField: PasswordField
    lateinit var confirmPasswordField: PasswordField

    @PostConstruct
    fun postConstruct () {
        presenter.linkBind()
    }

    init {
        presenter.view = this
        verticalLayout {
            passwordField        = passwordField("Пароль")
            confirmPasswordField = passwordField("Подтвердите пароль")

            button("Сбросить пароль") {
                addClickListener {
                    presenter.submitForm()
                }
            }
        }
    }

    override fun setParameter(event: BeforeEvent?, parameter: String) {
//        presenter.form.droppedToken = parameter
    }
}
