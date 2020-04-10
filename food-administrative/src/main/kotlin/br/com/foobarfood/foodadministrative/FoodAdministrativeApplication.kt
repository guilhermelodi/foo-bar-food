package br.com.foobarfood.foodadministrative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodAdministrativeApplication

fun main(args: Array<String>) {
	runApplication<FoodAdministrativeApplication>(*args)
}
