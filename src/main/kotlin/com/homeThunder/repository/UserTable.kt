package com.homeThunder.repository

import com.homeThunder.services.createAt
import com.homeThunder.services.updateAt

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

object UserTable : IntIdTable("User") {
    val firstname = varchar("firstname", 255)
    val lastname = varchar("lastname", 255)
    val patronymic = varchar("patronymic", 255).nullable()
    val birthday = date("birthday").nullable()
    val phone = varchar("phone", 255).nullable()
    val email = varchar("email", 255).uniqueIndex()
    val password = varchar("password", 255)
    val salt = varchar("salt", 255)

    val updateAt = updateAt()
    val createAt = createAt()
}
