package com.homeThunder.data.forms

import kotlinx.serialization.Serializable

@Serializable
data class FlatForm(
    val number: Int,
    val buildId: Int,

    val floor: Int,
    val entrance: Int,

    val registryNumber: Int,

    val ownerId: Int,
)
