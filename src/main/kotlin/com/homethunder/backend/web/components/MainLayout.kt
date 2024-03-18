package com.homethunder.backend.web.components

import com.github.mvysny.karibudsl.v10.button
import com.github.mvysny.karibudsl.v10.h1
import com.homethunder.backend.security.SecurityService
import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.html.Header
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.Scroller
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.sidenav.SideNav
import com.vaadin.flow.component.sidenav.SideNavItem
import com.vaadin.flow.router.RouterLayout
import com.vaadin.flow.theme.lumo.LumoUtility

class MainLayout(
    private val securityService: SecurityService
) : AppLayout(), RouterLayout {
    val appHeader = Header().apply {
        h1("HomeThunder")
    }

    val appMenu = SideNav().apply {
        addItem(SideNavItem("Главная", "/"))
        addItem(SideNavItem("Новости", "/posts"))
    }

    val toggle = DrawerToggle().apply {

    }

    init {
        val toggle = DrawerToggle()

        val scroller = VerticalLayout().apply {
            justifyContentMode = FlexComponent.JustifyContentMode.BETWEEN
            alignItems = FlexComponent.Alignment.START
            height = "100%"



            add(Scroller(appMenu))

            add(button("Выход"){
                icon = VaadinIcon.SIGN_OUT.create()
                addThemeVariants(ButtonVariant.LUMO_TERTIARY)
                addClickListener {
                    securityService.logout()
                }
            })
        }
        scroller.className = LumoUtility.Padding.SMALL

        addToDrawer(scroller)
        addToNavbar(toggle, appHeader)
    }


}
