package com.evocity.data.entity

import com.evocity.contract.ICreateAt
import com.evocity.contract.IId
import com.evocity.contract.IUpdateAt
import kotlinx.datetime.LocalDate

interface Worker : IId, IUpdateAt, ICreateAt {
    val userID: Int
    val position: String

    var startDate: LocalDate?
    var firedDate: LocalDate?

    val isFired: Boolean
}
