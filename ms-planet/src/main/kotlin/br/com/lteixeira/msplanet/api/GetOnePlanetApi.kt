package br.com.lteixeira.msplanet.api

import br.com.lteixeira.msplanet.api.model.GetOnePlanetResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus

interface GetOnePlanetApi {
    @Tag(name = "API Planetas")
    @Operation(summary = "Consultar planeta por nome")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Planeta encontrado com sucesso"),
        ApiResponse(responseCode = "404", description = "Planeta não encontrado")
    ])
    @GetMapping("planets/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun getOne(@PathVariable("name") name: String): GetOnePlanetResponse
}