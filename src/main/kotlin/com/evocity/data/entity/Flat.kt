package com.evocity.data.entity

import com.evocity.contract.ICreateAt
import com.evocity.contract.IId
import com.evocity.contract.IUpdateAt

interface Flat : IId, IUpdateAt, ICreateAt {
    val number: Int
    val houseId: Int

    val floor: Int
    val entrance: Int

    val registryNumber: Int

    var ownerId: Int
}
