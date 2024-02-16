package com.homethunder.backend.extensions

import io.konform.validation.Constraint
import io.konform.validation.ValidationBuilder
import kotlinx.datetime.LocalDate

fun ValidationBuilder<LocalDate>.before(date: LocalDate): Constraint<LocalDate> = addConstraint(
    "before '{0}'",
    date.toString()
) {
    it < date
}
