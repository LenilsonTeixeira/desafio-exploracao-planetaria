package br.com.lteixeira.msprobe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class MsProbeApplication

fun main(args: Array<String>) {
	runApplication<MsProbeApplication>(*args)
}
