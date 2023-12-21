package com.homeThunder.services

import kotlinx.datetime.*

fun LocalDateTime.Companion.now(): LocalDateTime {
    val now = Clock.System.now()
    val timeZone = TimeZone.currentSystemDefault()
    return now.toLocalDateTime(timeZone)
}
