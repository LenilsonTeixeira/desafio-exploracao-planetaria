package br.com.lteixeira.msplanet

import co.elastic.apm.attach.ElasticApmAttacher
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsPlanetApplication

fun main(args: Array<String>) {
	ElasticApmAttacher.attach()
	runApplication<MsPlanetApplication>(*args)
}
