package br.com.lteixeira.msplanet.api

import br.com.lteixeira.msplanet.api.model.UpdatePlanetRequest
import br.com.lteixeira.msplanet.api.model.UpdatedPlanetResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

interface UpdatePlanetApi {

    @PutMapping("planets/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("id") id: String, @Valid @RequestBody updatePlanetRequest: UpdatePlanetRequest): UpdatedPlanetResponse
}