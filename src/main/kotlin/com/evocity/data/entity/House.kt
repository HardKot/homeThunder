package com.evocity.data.entity

import com.evocity.contract.ICreateAt
import com.evocity.contract.IId
import com.evocity.contract.IUpdateAt

interface House : IId, ICreateAt, IUpdateAt {
    val address: String

    val city: String
    var street: String
    var house: String


}
