package com.homethunder.backend.web.views

import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.kaributools.navigateTo
import com.homethunder.backend.web.presenters.AuthPresenter
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.textfield.EmailField
import com.vaadin.flow.component.textfield.PasswordField
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed
import jakarta.annotation.PostConstruct


@Route("/auth")
@AnonymousAllowed
@PageTitle("Авторизация")
class AuthView(
    private val presenter: AuthPresenter
) : KComposite() {
    lateinit var emailField: EmailField
    lateinit var passwordField: PasswordField

    @PostConstruct
    fun postConstruct() {
        presenter.linkBind()
    }

    init {
        presenter.view = this
        ui {
            div("login-rich-content") {
                verticalLayout {
                    alignItems = FlexComponent.Alignment.CENTER
                    justifyContentMode = FlexComponent.JustifyContentMode.CENTER

                    formLayout {
                        h3("Авторизация")

                        emailField = emailField("Электронная почта")
                        passwordField = passwordField("Пароль")

                        button("Авторизация") {
                            addThemeVariants(ButtonVariant.LUMO_PRIMARY)
                            addClickListener {
                                presenter.submitForm()
                            }
                        }
                    }

                    button("Регистрация") {
                        addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SMALL)
                        addClickListener {
                            navigateTo("/registration")
                        }
                    }

                    button("Забыли пароль") {
                        addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SMALL)
                        addClickListener {
                            navigateTo("/dropPassword")
                        }
                    }
                }
            }
        }
    }
}
