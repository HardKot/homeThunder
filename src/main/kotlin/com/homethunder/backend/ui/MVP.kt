package com.homethunder.backend.ui

import com.github.mvysny.karibudsl.v10.KComposite
import com.vaadin.flow.component.Component

abstract class View(root: Component?
) : KComposite(root) {
    abstract val presenter: Presenter
}

abstract class Presenter(
    protected val model: Model
)


abstract class Model(
    protected val view: KComposite,
)
