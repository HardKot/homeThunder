package com.homeThunder.data.entity

import com.homeThunder.contract.ICreateAt
import com.homeThunder.contract.IID
import com.homeThunder.contract.IUpdateAt
import kotlinx.datetime.LocalDate

interface Resident : IID, ICreateAt, IUpdateAt {
    val userId: Int

    val flatId: Int

    val startDate: LocalDate
    val leaveDate: LocalDate?

}
