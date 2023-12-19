package com.evocity.data.forms

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class ResidentForm(
    val id: Int?,

    val userId: Int,

    val flatId: Int,

    val startDate: LocalDate,
    val leaveDate: LocalDate?,
)
