package com.homeThunder.repository

import com.homeThunder.services.createAt
import com.homeThunder.services.updateAt
import org.jetbrains.exposed.dao.id.IntIdTable

object ApartmentBuildingTable : IntIdTable("ApartmentBuilding") {
    val city = varchar("city", 255)
    val street = varchar("street", 255)
    val house = varchar("house", 255)

    val updateAt = updateAt()
    val createAt = createAt()
}
