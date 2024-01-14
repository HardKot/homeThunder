package com.homeThunder.extensions
import kotlinx.datetime.*

fun LocalDateTime.Companion.now(): LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

