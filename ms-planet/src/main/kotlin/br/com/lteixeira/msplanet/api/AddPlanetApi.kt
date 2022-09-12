package br.com.lteixeira.msplanet.api

import br.com.lteixeira.msplanet.api.model.AddPlanetRequest
import br.com.lteixeira.msplanet.api.model.AddedPlanetResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

interface AddPlanetApi {
    @Tag(name = "API Planetas")
    @Operation(summary = "Adicionar planetas")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Planeta adicionado com sucesso"),
        ApiResponse(responseCode = "400", description = "Atributos inválidos"),
        ApiResponse(responseCode = "422", description = "Planeta já existe um planeta cadastrado na base com mesmo nome")
    ])
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("planets")
    fun add(@Valid @RequestBody addPlanetRequest: AddPlanetRequest): AddedPlanetResponse
}