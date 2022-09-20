package br.com.lteixeira.msprobe.api

import br.com.lteixeira.msprobe.api.model.AddProbeLandingRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeLandingResponse
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

interface AddProbeLandingApi {
    @Tag(name = "API Sondas")
    @Operation(summary = "Adicionar pouso de sonda")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Pouso de sonda adicionado com sucesso"),
        ApiResponse(responseCode = "400", description = "Atributos inválidos")])
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("probes/{probe}/landing")
    fun addLanding(
        @PathVariable("probe") probe: String,
        @Valid @RequestBody addProbeLandingRequest: AddProbeLandingRequest
    ): AddedProbeLandingResponse
}