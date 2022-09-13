package br.com.lteixeira.msprobe.api

import br.com.lteixeira.msprobe.api.model.GetOneProbeResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus

interface GetOneProbeApi {
    @Tag(name = "API Sondas")
    @Operation(summary = "Consultar sonda por nome")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Sonda encontrada com sucesso"),
        ApiResponse(responseCode = "404", description = "Sonda não encontrada")
    ])
    @GetMapping("probes/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun getOne(@PathVariable("name") name: String): GetOneProbeResponse
}