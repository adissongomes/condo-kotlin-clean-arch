package com.adissongomes.condo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CondoApplication

fun main(vararg args: String) {
    runApplication<CondoApplication>(*args)
}
