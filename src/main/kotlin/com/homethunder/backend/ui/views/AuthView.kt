package com.homethunder.backend.ui.views

import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.kaributools.navigateTo
import com.homethunder.backend.ui.presenters.AuthPresenter
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.textfield.EmailField
import com.vaadin.flow.component.textfield.PasswordField
import com.vaadin.flow.router.Route
import jakarta.annotation.PostConstruct


@Route("/auth")
class AuthView(
    private val presenter: AuthPresenter
) : FormLayout() {
    lateinit var emailField: EmailField
    lateinit var passwordField: PasswordField

    @PostConstruct
    fun postConstruct () {
        presenter.linkBind()
    }

    init {
        presenter.view = this
        verticalLayout {
            h3("Авторизация")

            emailField           = emailField("Электронная почта")
            passwordField        = passwordField("Пароль")

            button("Авторизация") {
                addClickListener {
                    presenter.submitForm()
                }
            }

            button("Регистрация") {
                addClickListener {
                    navigateTo("/registration")
                }
            }

            button("Забыли пароль") {
                addClickListener {
                    navigateTo("/dropPassword")
                }
            }
        }
    }
}
