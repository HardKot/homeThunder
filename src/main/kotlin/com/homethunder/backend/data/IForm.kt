package com.homethunder.backend.data

import io.konform.validation.Validation

abstract class IForm<T> {

    abstract val validation: Validation<IForm<T>>

    protected val validateResult = validation.validate(this)

    val errors = validateResult.errors
}
