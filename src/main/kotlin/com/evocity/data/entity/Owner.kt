package com.evocity.data.entity

import com.evocity.contract.ICreateAt
import com.evocity.contract.IId
import com.evocity.contract.IUpdateAt

interface Owner : IId, IUpdateAt, ICreateAt  {
    val userId: Int
}
