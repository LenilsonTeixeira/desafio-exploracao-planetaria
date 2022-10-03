package br.com.lteixeira.msprobe.api

import br.com.lteixeira.msprobe.api.model.AddProbeCommandRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeCommandResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

interface AddProbeCommandApi {
    @Tag(name = "API Sondas")
    @Operation(summary = "Enviar comandos para sonda")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Comando adicionado com sucesso"),
        ApiResponse(responseCode = "400", description = "Atributos inválidos")])
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("probes/{probe}/{planet}/command")
    fun addCommand(@PathVariable("probe") probe: String,
                   @PathVariable("planet") planet: String,
                   @Valid @RequestBody addProbeCommandRequest: AddProbeCommandRequest): AddedProbeCommandResponse
}