package com.homeThunder.data.entity

import com.homeThunder.contract.ICreateAt
import com.homeThunder.contract.IID
import com.homeThunder.contract.IUpdateAt
import kotlinx.datetime.LocalDate

interface User : IID, IUpdateAt, ICreateAt {
    val firstname: String
    val lastname: String
    val patronymic: String?

    val birthday: LocalDate?

    val phone: String?

    val email: String
    val password: String
    val salt: String
}
