package com.homethunder.backend.data

import com.vaadin.flow.data.binder.ValidationResult
import com.vaadin.flow.data.binder.Validator
import io.konform.validation.Validation

abstract class Form<IForm, T : IForm> {
    abstract val validation: Validation<T>
    abstract val validationResult: io.konform.validation.ValidationResult<T>

    val errors
        get() = validationResult.errors

    abstract operator fun <F> set(path: Any, value: F)

    fun <F> validatorField(propertyPath: Any): Validator<F> = Validator<F> { value, context ->
        this[propertyPath] = value

        val result =
            validationResult[propertyPath] ?: emptyList()

        if (result.isEmpty()) return@Validator ValidationResult.ok()
        else return@Validator ValidationResult.error(result.joinToString("\n"))
    }
}
