package com.homeThunder.repository

import com.homeThunder.services.createAt
import com.homeThunder.services.updateAt
import org.jetbrains.exposed.dao.id.IntIdTable

object FlatTable : IntIdTable("Flat") {
    val number = integer("number")
    val buildId = reference("house_id", ApartmentBuildingTable)

    val floor = integer("floor")
    val entrance = integer("entrance")

    val registryNumber = integer("registry_number").nullable()

    val ownerId = reference("owner_id", UserTable)

    val updateAt = updateAt()
    val createAt = createAt()
}
