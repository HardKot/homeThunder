package com.evocity.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class FlatDTO(
    val id: Int,

    val houseId: Int,

    val floor: Int,
    val entrance: Int,

    val registryNumber: Int,

    var ownerId: Int,


    val address: String,

    val city: String,
    var street: String,
    var house: String,

    val number: Int,

    val updateAt: LocalDateTime,
    val createAt: LocalDateTime,
)
