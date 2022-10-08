package br.com.lteixeira.msprobe

import co.elastic.apm.attach.ElasticApmAttacher
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableFeignClients
@EnableJpaRepositories
@SpringBootApplication
class MsProbeApplication

fun main(args: Array<String>) {
	ElasticApmAttacher.attach()
	runApplication<MsProbeApplication>(*args)
}
