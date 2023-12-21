package com.homeThunder.data.entity

import com.homeThunder.contract.ICreateAt
import com.homeThunder.contract.IID
import com.homeThunder.contract.IUpdateAt

interface ApartmentBuilding : IID, ICreateAt, IUpdateAt {
    val address: String

    val city: String
    val street: String
    val house: String
}
