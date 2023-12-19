package com.evocity.dto

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable


@Serializable
data class OwnerDTO(
    val id: Int,

    val userId: Int,

    var firstname: String,
    var lastname: String,
    var patronymic: String?,

    var birthday: LocalDate?,

    var phone: String?,

    var email: String,
    var password: String,
    var salt: String,

    val updateAt: LocalDateTime,
    val createAt: LocalDateTime,
)
