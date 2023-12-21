package com.homeThunder.services

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

fun org.jetbrains.exposed.sql.Table.updateAt() = datetime("update_at").default(LocalDateTime.now())
fun org.jetbrains.exposed.sql.Table.createAt() = datetime("create_at").default(LocalDateTime.now())
