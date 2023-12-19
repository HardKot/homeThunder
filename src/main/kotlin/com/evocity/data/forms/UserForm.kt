package com.evocity.data.forms

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

sealed class UserForm {
    abstract val firstname: String
    abstract val lastname: String
    abstract val patronymic: String?

    abstract val birthday: LocalDate?

    abstract val phone: String?
    abstract val email: String

    @Serializable
    data class WorkerForm(
        val id: Int?,
        val position: String,

        val startDate: LocalDate?,
        val firedDate: LocalDate?,

        val isFired: Boolean,
        override val firstname: String,
        override val lastname: String,
        override val patronymic: String?,
        override val birthday: LocalDate?,
        override val phone: String?,
        override val email: String,
    ) : UserForm()

    @Serializable
    data class ResidentForm(
        val id: Int?,
        val flatId: Int,

        val startDate: LocalDate,
        val leaveDate: LocalDate?,

        override val firstname: String,
        override val lastname: String,
        override val patronymic: String?,

        override val birthday: LocalDate?,

        override val phone: String?,
        override val email: String,
    ) : UserForm()

    @Serializable
    data class BaseForm(
        val id: Int?,
        val password: String,
        override val firstname: String,
        override val lastname: String,
        override val patronymic: String?,
        override val birthday: LocalDate?,
        override val phone: String?,
        override val email: String,
    ) : UserForm()
}


