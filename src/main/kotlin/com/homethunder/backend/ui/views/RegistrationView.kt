package com.homethunder.backend.ui.views

import com.github.mvysny.karibudsl.v10.*
import com.homethunder.backend.domain.enums.Gender
import com.homethunder.backend.extensions.Year
import com.homethunder.backend.extensions.today
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.dom.Style
import com.vaadin.flow.router.Route
import com.homethunder.backend.ui.presenters.RegistrationPresenter
import com.vaadin.flow.component.ItemLabelGenerator
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.textfield.*
import com.vaadin.flow.component.select.Select
import kotlinx.datetime.*

@Route("/registration")
class RegistrationView(
    private val presenter: RegistrationPresenter,
) : FormLayout() {

    lateinit var firstnameField: TextField
    lateinit var lastnameField: TextField
    lateinit var patronymicField: TextField
    lateinit var birthdayField: DatePicker
    lateinit var genderSelector: Select<Gender>

    lateinit var emailField: EmailField
    lateinit var passwordField: PasswordField
    lateinit var confirmPasswordField: PasswordField

    init {
        presenter.view = this
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

                    firstnameField  = textField("Имя")
                    lastnameField   = textField("Фамилия")
                    patronymicField = textField("Отчество")

                    birthdayField   = datePicker("Дата рождения") {
                        val initDate = LocalDate.today()
                        initialPosition = initDate.toJavaLocalDate()
                    }

                    genderSelector  = select("Пол") {
                        isEmptySelectionAllowed = true
                        emptySelectionCaption = "Пол не выбран"
                        setItems(Gender.Male, Gender.Famale)
                        itemLabelGenerator = ItemLabelGenerator { when (it) {
                            Gender.Male -> "Мужской"
                            Gender.Famale -> "Женский"
                            else -> "Пол не выбран"
                        }}
		            }

                    emailField           = emailField("Электронная почта")
                    passwordField        = passwordField("Пароль")
                    confirmPasswordField = passwordField("Подтвердите пароль")

                    setResponsiveSteps(FormLayout.ResponsiveStep("0", 1))


                    button("Зарегистрироваться") {
                        addClickListener {
                            presenter.submitForm()
                        }
                    }
                }
            }
            presenter.linkBind()
        }
    }
}
