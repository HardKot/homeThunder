package com.homeThunder.repository

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

import com.homeThunder.services.createAt
import com.homeThunder.services.now
import com.homeThunder.services.updateAt
import kotlinx.datetime.LocalDateTime

object WorkerTable : IntIdTable("Worker") {
    val userID = reference("user_id", UserTable)
    val position = varchar("position", 255)

    val startDate = date("start_date").default(LocalDateTime.now().date)
    val firedDate = date("fired_date").nullable()

    val updateAt = updateAt()
    val createAt = createAt()
}
