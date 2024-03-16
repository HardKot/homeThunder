package com.homethunder.backend.web.views

import com.github.mvysny.karibudsl.v10.*
import com.homethunder.backend.web.presenters.DropPasswordPresenter
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.textfield.EmailField
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed
import jakarta.annotation.PostConstruct

@Route("/dropPassword")
@AnonymousAllowed
@PageTitle("Сброс пароля")
class DropPasswordView(
    private val presenter: DropPasswordPresenter
) : KComposite() {
    lateinit var emailField: EmailField

    @PostConstruct
    fun postConstruct () {
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
                        h3("Сбросить пароль")
                        emailField = emailField("Электронная почта")
                        button("Сбросить пароль") {
                            addClickListener {
                                presenter.submitForm()
                            }
                        }
                    }
                }
            }
        }
    }
}
