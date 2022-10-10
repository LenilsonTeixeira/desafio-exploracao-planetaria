package br.com.lteixeira.msimpactanalyzer

import co.elastic.apm.attach.ElasticApmAttacher
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsImpactAnalyzerApplication

fun main(args: Array<String>) {
	ElasticApmAttacher.attach()
	runApplication<MsImpactAnalyzerApplication>(*args)
}
