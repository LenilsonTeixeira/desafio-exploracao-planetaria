package br.com.lteixeira.msplanet.api

import br.com.lteixeira.msplanet.api.model.AddPlanetRequest
import br.com.lteixeira.msplanet.api.model.AddedPlanetResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

interface AddPlanetApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("planets")
    fun add(@Valid @RequestBody addPlanetRequest: AddPlanetRequest): AddedPlanetResponse
}