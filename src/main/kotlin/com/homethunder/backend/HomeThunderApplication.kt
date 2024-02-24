package com.homethunder.backend

import org.jetbrains.exposed.spring.autoconfigure.ExposedAutoConfiguration
import org.jetbrains.exposed.sql.Database
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@ImportAutoConfiguration(
    value = [ExposedAutoConfiguration::class],
)
class HomeThunderApplication

fun main(args: Array<String>) {
    Database.connect("jdbc:postgresql://localhost:12346/test", driver = "org.postgresql.Driver",
        user = "myuser", password = "secret")
    runApplication<HomeThunderApplication>(*args)
}
