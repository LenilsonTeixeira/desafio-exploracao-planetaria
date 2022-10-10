package br.com.lteixeira.msimpactanalyzer.controller

import br.com.lteixeira.msimpactanalyzer.builder.QueryBuilder
import br.com.lteixeira.msimpactanalyzer.model.ProbeData
import br.com.lteixeira.msimpactanalyzer.model.SearchRequestParam
import br.com.lteixeira.msimpactanalyzer.service.ProbeCollisionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("probes")
@RestController
class ProbeCollisionController(private val probeCollisionService: ProbeCollisionService) {

    @GetMapping("/collision")
    fun search(searchRequestParam: SearchRequestParam): ProbeData {
        val request = QueryBuilder().build(searchRequestParam)
        return probeCollisionService.search(request)
    }
}