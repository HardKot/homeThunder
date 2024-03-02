package com.homethunder.backend.data

import io.konform.validation.Validation

data class DropPasswordForm(
    override var email: String? = null
) : IDropPasswordForm, Form<IDropPasswordForm, DropPasswordForm>() {
    constructor() : this(null)

    override operator fun <F> set(path: Any, value: F) {
        when (path) {
            DropPasswordForm::email -> email = value as String
        }
    }

    override val validationResult
        get() = validation(this)

    override val validation = Validation<DropPasswordForm> {
        DropPasswordForm::email required {}
    }
}
