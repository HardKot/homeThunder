package com.homethunder.backend.web.views

import com.github.mvysny.karibudsl.v10.*
import com.homethunder.backend.domain.enums.Gender
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.dom.Style
import com.vaadin.flow.router.Route
import com.homethunder.backend.web.presenters.RegistrationPresenter
import com.vaadin.flow.component.ItemLabelGenerator
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.progressbar.ProgressBar
import com.vaadin.flow.component.textfield.*
import com.vaadin.flow.component.select.Select
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.server.auth.AnonymousAllowed
import java.time.LocalDate


@Route("/registration")
@PageTitle("Регистрация")
@AnonymousAllowed
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

    lateinit var progressBarView: ProgressBar
    lateinit var submitButton: Button

    init {
        verticalLayout {
            progressBarView = progressBar {  }

            width = "100%"

            style.apply {
                setFlexGrow(1.0)
                setJustifyContent(Style.JustifyContent.START)
                alignItems = FlexComponent.Alignment.START
            }

            h3("Регистрация")

            h5("Персональная информация")

            formLayout {
                width = "100%"
                maxWidth = "800px"
                height = "min-content"

                firstnameField  = textField("Имя")
                lastnameField   = textField("Фамилия")
                patronymicField = textField("Отчество")

                birthdayField   = datePicker("Дата рождения") {
                    value = LocalDate.now()
                }

                genderSelector  = select("Пол") {
                    setItems(Gender.Unknown, Gender.Male, Gender.Famale)
                    itemLabelGenerator = ItemLabelGenerator { when (it) {
                        Gender.Male -> "Мужской"
                        Gender.Famale -> "Женский"
                        else -> "Пол не выбран"
                    }}
                    value = Gender.Unknown
                }

                emailField = emailField("Электронная почта")
            }

            h5("Безопасность")

            formLayout {
                width = "100%"
                maxWidth = "800px"
                height = "min-content"

                passwordField        = passwordField("Пароль")
                confirmPasswordField = passwordField("Подтвердите пароль")
            }

            submitButton = button("Зарегистрироваться") {
                addClickListener {
                    presenter.submitForm()
                }
            }
        }

        presenter.setView(this)
    }
}
