package com.homeThunder.repository.columns

import com.homeThunder.data.enums.Gender
import com.homeThunder.extensions.now
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.jetbrains.exposed.sql.Table

fun Table.updateAt() = datetime("update_at").default(LocalDateTime.now())
fun Table.createAt() = datetime("create_at").default(LocalDateTime.now())

fun Table.gender(name: String) = customEnumeration(name, "Gender", {value -> Gender.valueOf(value as String)}, { PGEnum("Gender", it) })

