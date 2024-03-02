package com.homethunder.backend.ui.presenters

import com.homethunder.backend.data.Form
import com.vaadin.flow.component.AbstractField
import com.vaadin.flow.data.binder.Binder
import io.konform.validation.ValidationErrors
import kotlin.reflect.KMutableProperty1

abstract class FormPresenter<BEAN : Form<*, *>>(
    classBean: Class<BEAN>,
    val form: BEAN
) {
    private val binder = Binder(classBean)

    fun <TARGET, NEW_TARGET> bind(
        field: AbstractField<*, TARGET>,
        property: KMutableProperty1<BEAN, NEW_TARGET>,
        dsl: Binder.BindingBuilder<BEAN, TARGET>.() -> Unit
    ) = binder.forField(field).apply {
        dsl(this)
        withValidator(form.validatorField(property))
        bind(property.name)
    }

    fun <TARGET> bind(
        field: AbstractField<*, TARGET>,
        property: KMutableProperty1<BEAN, TARGET>,
    ) = binder.forField(field).apply {
        withValidator(form.validatorField(property))
        bind(property.name)
    }

    fun validate() = binder.validate()
}
