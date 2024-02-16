package com.homethunder.backend.ui.models

import com.github.mvysny.karibudsl.v10.KComposite
import com.homethunder.backend.domain.enums.Gender
import kotlinx.datetime.LocalDate
import com.homethunder.backend.ui.Model

class RegistrationModel(view: KComposite) : Model(view) {
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var patronymic: String

    lateinit var birthday: LocalDate
    lateinit var gender: Gender

    lateinit var email: String
    lateinit var password: String
    lateinit var confirmPassword: String
}
