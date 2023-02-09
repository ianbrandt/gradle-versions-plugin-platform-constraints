package org.sdkotlin.springdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
	runApplication<SpringBootApp>(*args)
}

@SpringBootApplication
class SpringBootApp
