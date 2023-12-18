package com.evocity.data.entity

import com.evocity.contract.ICreateAt
import com.evocity.contract.IId
import com.evocity.contract.IUpdateAt
import kotlinx.datetime.LocalDate

interface Resident : IId, ICreateAt, IUpdateAt {
    val userId: Int

    val flatId: Int

    val startDate: LocalDate
    val leaveDate: LocalDate?

}
