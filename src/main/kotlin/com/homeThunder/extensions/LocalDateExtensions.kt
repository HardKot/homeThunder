package com.homeThunder.extensions

import kotlinx.datetime.*

fun LocalDate.Companion.now(): LocalDate = Clock.System.todayIn(TimeZone.currentSystemDefault())
