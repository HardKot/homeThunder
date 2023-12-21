package com.homeThunder.data.forms

import kotlinx.serialization.Serializable

@Serializable
data class AartmentBuildingForm(
    val address: String,

    val city: String,
    var street: String,
    var house: String,
)
