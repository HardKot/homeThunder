package com.homeThunder.repository

import com.homeThunder.services.createAt
import com.homeThunder.services.updateAt
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

object ResidentTable : IntIdTable("Resident") {

    val userId = reference("user_id", UserTable)
    val flatId = reference("flat_id", FlatTable)

    val startDate = date("start_date")
    val leaveDate = date("leave_date").nullable()

    val updateAt = updateAt()
    val createAt = createAt()
}
