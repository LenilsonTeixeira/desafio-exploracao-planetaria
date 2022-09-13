package br.com.lteixeira.msprobe.api

import br.com.lteixeira.msprobe.api.model.UpdateProbeRequest
import br.com.lteixeira.msprobe.api.model.UpdatedProbeResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

interface UpdateProbeApi {
    @Tag(name = "API Sondas")
    @Operation(summary = "Atualizar sondas")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Sonda atualizada com sucesso"),
        ApiResponse(responseCode = "400", description = "Atributos inválidos"),
        ApiResponse(responseCode = "422", description = "Já existe outra sonda cadastrada na base com mesmo nome")
    ])
    @PutMapping("probes/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable("id") id: String,
        @Valid @RequestBody updateProbeRequest: UpdateProbeRequest
    ): UpdatedProbeResponse
}