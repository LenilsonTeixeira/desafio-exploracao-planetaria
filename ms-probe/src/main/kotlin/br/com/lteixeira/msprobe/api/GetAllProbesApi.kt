package br.com.lteixeira.msprobe.api

import br.com.lteixeira.msprobe.api.model.GetAllProbesResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

interface GetAllProbesApi {
    @Tag(name = "API Sondas")
    @Operation(summary = "Consultar lista paginada de sondas")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Resultado da consulta paginada"),
        ApiResponse(responseCode = "400", description = "Parâmetro obrigatório não informado")
    ])
    @GetMapping("probes")
    @ResponseStatus(HttpStatus.OK)
    fun getAll(@RequestParam("page") page: Int, @RequestParam("size") size: Int): Page<GetAllProbesResponse>
}