package com.evocity.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class AartmentBuildingDTO(
    val id: Int,

    val address: String,

    val city: String,
    var street: String,
    var house: String,

    val updateAt: LocalDateTime,
    val createAt: LocalDateTime,
)
