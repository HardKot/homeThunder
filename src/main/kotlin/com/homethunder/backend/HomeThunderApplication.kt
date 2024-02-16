package com.homethunder.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomeThunderApplication

fun main(args: Array<String>) {
    runApplication<HomeThunderApplication>(*args)
}
