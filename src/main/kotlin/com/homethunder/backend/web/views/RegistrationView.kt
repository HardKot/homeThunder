package com.homethunder.backend.web.views

import com.github.mvysny.karibudsl.v10.*
import com.homethunder.backend.domain.enums.Gender
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.dom.Style
import com.vaadin.flow.router.Route
import com.homethunder.backend.web.presenters.RegistrationPresenter
import com.vaadin.flow.component.ItemLabelGenerator
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.textfield.*
import com.vaadin.flow.component.select.Select
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import com.vaadin.flow.theme.material.Material


@Route("/registration")
@Theme(value = Lumo.LIGHT)
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
        verticalLayout {
            style.apply {
                setJustifyContent(Style.JustifyContent.CENTER)
                setAlignItems(Style.AlignItems.CENTER)
            }

            h3("Регистрация")

            firstnameField  = textField("Имя")
            lastnameField   = textField("Фамилия")
            patronymicField = textField("Отчество")

            birthdayField   = datePicker("Дата рождения") {

            }

            genderSelector  = select("Пол") {
                isEmptySelectionAllowed = true
                emptySelectionCaption = "Пол не выбран"
                setItems(Gender.Male, Gender.Famale)
                itemLabelGenerator = ItemLabelGenerator { when (it) {
                    Gender.Male -> "Мужской"
                    Gender.Famale -> "Женский"
                    else -> emptySelectionCaption
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

//        presenter.setView(this)
    }
}