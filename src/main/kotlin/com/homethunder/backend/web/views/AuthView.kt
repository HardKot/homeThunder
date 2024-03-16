package com.homethunder.backend.web.views

import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.kaributools.addThemeVariantsCompat
import com.github.mvysny.kaributools.navigateTo
import com.homethunder.backend.web.presenters.AuthPresenter
import com.vaadin.flow.component.HasText
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.checkbox.Checkbox
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.notification.NotificationVariant
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
    private val dropPasswordModalView = Dialog()

    lateinit var dropPasswordEmailField: EmailField

    lateinit var emailField: EmailField
    lateinit var passwordField: PasswordField
    lateinit var remberMeField: Checkbox

    @PostConstruct
    fun postConstruct() {
        presenter.linkBind()
    }

    init {
        presenter.view = this
        dropPasswordModalView.apply {
            isModal = true
            headerTitle = "Сбросить пароль"
            formLayout {
                verticalLayout {
                    span("Укажите вашу почту и мы вышлем вам ссылку для сброса пароля") {
                        style.apply {
                            setFontSize("14px")
                            whiteSpace = HasText.WhiteSpace.NOWRAP
                        }
                    }
                    dropPasswordEmailField = emailField("Электронная почта") {
                        width = "100%"
                    }
                }
            }

            footer.add(button("Сбросить пароль") {
                addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SMALL)
                addClickListener {
                    presenter.dropPassword()
                    dropPasswordModalView.close()
                    Notification.show("Запрос на восстановление направлен на вашу почту.", 3000, Notification.Position.TOP_END).apply {
                        addThemeVariants(NotificationVariant.LUMO_PRIMARY)
                    }
                }
            }, button("Отмена") {
                style.setMarginLeft("12px")
                addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SMALL)
                addClickListener {
                    dropPasswordModalView.close()
                }
            })


        }

        ui {
            div("login-rich-content") {
                verticalLayout {
                    alignItems = FlexComponent.Alignment.CENTER
                    justifyContentMode = FlexComponent.JustifyContentMode.CENTER

                    formLayout {
                        h3("Авторизация")

                        emailField = emailField("Электронная почта")
                        passwordField = passwordField("Пароль")

                        horizontalLayout {
                            alignItems = FlexComponent.Alignment.CENTER
                            justifyContentMode = FlexComponent.JustifyContentMode.BETWEEN

                            remberMeField = checkBox("Запомнить меня")

                            button("Забыли пароль") {
                                addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SMALL)
                                addClickListener {
                                    dropPasswordModalView.open()
                                }
                            }
                        }

                        button("Авторизация") {
                            style.setMarginTop("24px")
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
                }
            }
        }
    }


}
