package com.homethunder.backend.ui.views

import com.github.mvysny.karibudsl.v10.*
import com.homethunder.backend.domain.enums.Gender
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.dom.Style
import com.vaadin.flow.router.Route
import com.homethunder.backend.ui.presenters.RegistrationPresenter


@Route("/registration")
class RegistrationView : KComposite() {
    private val presenter = RegistrationPresenter(this)

    private val root = ui {
        div {
            div {
                style.apply {
                    setBackgroundColor("#0718C4")
                    setHeight("50px")
                    setPadding("5px 12px")
                    setBorderRadius("0px 0px 25px 25px")
                }
                image("/logo-no-background.png") {
                    style.apply {
                        setHeight("50px")
                        setWidth("50px")
                    }
                }

            }

            div {
                style.apply {
                    setBackgroundColor("#FFF")
                    setWidth("100%")
                    setDisplay(Style.Display.FLEX)
                    setJustifyContent(Style.JustifyContent.CENTER)
                    setAlignItems(Style.AlignItems.CENTER)
                }
                formLayout {
                    style.apply {
                        setWidth("560px")
                        setJustifyContent(Style.JustifyContent.CENTER)
                        setAlignItems(Style.AlignItems.CENTER)
                    }

                    h3("Регистрация")

                    textField("Имя")
                    textField("Фамилия")
                    textField("Отчество")
                    datePicker("Дата рождения")
                    select("Пол") {
                        setItems(Gender.Male, Gender.Famale)
                    }

                    emailField("Электронная почта")

                    passwordField("Пароль")
                    passwordField("Подтвердите пароль")

                    setResponsiveSteps(FormLayout.ResponsiveStep("0", 1))


                    button("Зарегистрироваться") {
                        println("test")
                    }
                }
            }
        }
    }
}
