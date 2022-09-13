package br.com.lteixeira.msprobe.api

import br.com.lteixeira.msprobe.api.model.AddProbeRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

interface AddProbeApi {
    @Tag(name = "API Sondas")
    @Operation(summary = "Adicionar sondas")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Sonda adicionada com sucesso"),
        ApiResponse(responseCode = "400", description = "Atributos inválidos"),
        ApiResponse(responseCode = "422", description = "Sonda já existe na base")
    ])
    @PostMapping("probes")
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@Valid @RequestBody addProbeRequest: AddProbeRequest): AddedProbeResponse
}