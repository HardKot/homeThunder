package com.evocity.data.entity

import com.evocity.contract.ICreateAt
import com.evocity.contract.IId
import com.evocity.contract.IUpdateAt
import kotlinx.datetime.LocalDate

interface User : IId, IUpdateAt, ICreateAt {
    var firstname: String
    var lastname: String
    var patronymic: String?

    var birthday: LocalDate?

    var phone: String?

    var email: String
    var password: String
    var salt: String
}
