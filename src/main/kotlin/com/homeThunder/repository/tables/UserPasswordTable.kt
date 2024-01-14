package com.homeThunder.repository.tables

import org.jetbrains.exposed.sql.Table

object UserPasswordTable : Table("UserPassword") {
    val user = reference("user", UserTable)

    val password = binary("password")
    val salt = binary("salt")
}
