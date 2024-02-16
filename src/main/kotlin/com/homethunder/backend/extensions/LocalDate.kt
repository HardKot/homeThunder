package com.homethunder.backend.extensions

import kotlinx.datetime.*

fun LocalDate.Companion.today(): LocalDate {
    return LocalDateTime.now().date
}
