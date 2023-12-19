package com.evocity.data.forms

import kotlinx.serialization.Serializable

@Serializable
data class FlatForm(
    val number: Int,
    val houseId: Int,

    val floor: Int,
    val entrance: Int,

    val registryNumber: Int,

    var ownerId: Int,
)
