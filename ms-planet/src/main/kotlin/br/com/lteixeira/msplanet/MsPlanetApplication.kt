package br.com.lteixeira.msplanet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsPlanetApplication

fun main(args: Array<String>) {
	runApplication<MsPlanetApplication>(*args)
}
