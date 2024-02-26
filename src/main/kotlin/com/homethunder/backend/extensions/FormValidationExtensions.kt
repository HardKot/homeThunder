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

fun ValidationBuilder<String>.unique(callback: (value: String) -> Boolean): Constraint<String> = addConstraint(
    "Value must be unique"
) {
    callback(it)
}

fun ValidationBuilder<String>.equals (value: String): Constraint<String> = addConstraint(
    "Value must be equals '{0}'",
    value
) {
    it == value
}


//fun <T, F> Validation<T>.validator(field: String): Validator<F> {
//    val validate = validate(this)
//
//    return Validator<F> { value, context ->
//        val result = validate(value)
//        val errors = result.errors
//
//        if (errors.isEmpty()) return@Validator ValidationResult.ok()
//        else return@Validator ValidationResult.error(errors.joinToString { it.message })
//    }
//}
