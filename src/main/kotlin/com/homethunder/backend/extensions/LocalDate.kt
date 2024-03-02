package com.homethunder.backend.extensions

import kotlinx.datetime.*

fun LocalDate.Companion.today(): LocalDate {
    return LocalDateTime.now().date
}

val Int.Year get() = DateTimeUnit.YEAR * this
val Int.Day get() = DateTimeUnit.DAY * this


operator fun LocalDate.minus(value: DateTimeUnit.DateBased): LocalDate {
    return this.plus(-1, value)
}

operator fun LocalDate.plus(value: DateTimeUnit.DateBased): LocalDate {
    return this.plus(1, value)
}
