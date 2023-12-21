package com.homeThunder.data.entity

import com.homeThunder.contract.ICreateAt
import com.homeThunder.contract.IID
import com.homeThunder.contract.IUpdateAt

interface Flat : IID, IUpdateAt, ICreateAt {
        val number: Int
        val buildId: Int

        val floor: Int
        val entrance: Int

        val registryNumber: Int

        val ownerId: Int
}
