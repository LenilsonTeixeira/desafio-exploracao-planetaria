package br.com.lteixeira.msplanet.api

import br.com.lteixeira.msplanet.api.model.GetOnePlanetResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus


interface GetOnePlanetApi {

    @GetMapping("planets/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun getOne(@PathVariable("name") name: String): GetOnePlanetResponse
}