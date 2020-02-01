package ru.jenny.simplews

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleWsApplication

fun main(args: Array<String>) {
	runApplication<SimpleWsApplication>(*args)
}
