package com.homethunder.backend.domain.table

import com.homethunder.backend.domain.enums.Gender
import org.jetbrains.exposed.sql.kotlin.datetime.date

object UsersTable : BaseEntityTable("users") {
    val firstname = varchar("firstname", 255)
    val lastname = varchar("lastname", 255)
    val patronymic = varchar("patronymic", 255).nullable()
    val gender = customEnumeration("gender", "Gender", {value -> Gender.valueOf(value as String)}, { PGEnum("Gender", it) }).nullable()
    val birthday = date("birthday").nullable()

    val email = varchar("email", 255).uniqueIndex()

    val avatarId = uuid("avatar_id").nullable()

    val password = binary("password")
    val passwordSalt = binary("password_salt")
}
