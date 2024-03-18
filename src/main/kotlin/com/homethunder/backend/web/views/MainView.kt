package com.homethunder.backend.web.views

import com.github.mvysny.karibudsl.v10.KComposite
import com.github.mvysny.karibudsl.v10.div
import com.github.mvysny.karibudsl.v10.h3
import com.homethunder.backend.web.components.MainLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed
import jakarta.annotation.security.PermitAll


@Route("/", layout = MainLayout::class)
@PageTitle("Главная")
@PermitAll
class MainView : KComposite() {
    init {
        ui {
            div {
                h3("Главная")
            }
        }
    }
}
