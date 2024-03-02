package com.homethunder.backend.extensions

import kotlinx.datetime.*
import java.util.Date

fun LocalDateTime.Companion.now(): LocalDateTime {
    val current = Clock.System.now()
    val timeZone = TimeZone.currentSystemDefault()
    return current.toLocalDateTime(timeZone)
}
val Int.Hour get() = DateTimeUnit.HOUR * this

operator fun LocalDateTime.plus(value: DateTimeUnit.TimeBased): LocalDateTime {
    val timeZone = TimeZone.currentSystemDefault()
    return toInstant(timeZone).plus(value).toLocalDateTime(timeZone)
}

fun LocalDateTime.toDate() = Date(toInstant(TimeZone.currentSystemDefault()).epochSeconds * 1000)
