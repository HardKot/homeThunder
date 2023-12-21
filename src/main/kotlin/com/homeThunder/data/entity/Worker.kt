package com.homeThunder.data.entity

import com.homeThunder.contract.ICreateAt
import com.homeThunder.contract.IID
import com.homeThunder.contract.IUpdateAt
import kotlinx.datetime.LocalDate

interface Worker : IID, IUpdateAt, ICreateAt {
    val userID: Int
    val position: String

    val startDate: LocalDate
    val firedDate: LocalDate?

    val isFired: Boolean
}
