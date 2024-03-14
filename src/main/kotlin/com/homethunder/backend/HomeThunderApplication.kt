package com.homethunder.backend

import com.vaadin.flow.component.page.AppShellConfigurator
import com.vaadin.flow.theme.Theme
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@Theme("homeThunder")
class HomeThunderApplication : AppShellConfigurator

fun main(args: Array<String>) {

    runApplication<HomeThunderApplication>(*args)
}
