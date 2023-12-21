package com.homeThunder.data.forms

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class WorkerForm(
    val id: Int?,

    val userId: Int,
    val position: String,

    val startDate: LocalDate?,
    val firedDate: LocalDate?,

    val isFired: Boolean,
)
