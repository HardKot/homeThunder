package com.homethunder.backend.extensions

import com.vaadin.flow.component.HasValue
import com.vaadin.flow.data.binder.Binder

fun <BEAN, FIELD_VALUE> Binder<BEAN>.forField(field: HasValue<*, FIELD_VALUE>, dsl: Binder.BindingBuilder<BEAN, FIELD_VALUE>.() -> Unit) = forField(field).apply(dsl)
