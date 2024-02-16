package com.homethunder.backend.extensions

import kotlinx.datetime.*

fun LocalDateTime.Companion.now(): LocalDateTime {
    val current = Clock.System.now()
    val timeZone = TimeZone.currentSystemDefault()
    return current.toLocalDateTime(timeZone)
}
