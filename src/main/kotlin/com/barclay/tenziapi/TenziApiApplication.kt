package com.barclay.tenziapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TenziApiApplication

fun main(args: Array<String>) {
    runApplication<TenziApiApplication>(*args)
}
