package br.com.lteixeira.msplanet.api

import br.com.lteixeira.msplanet.api.model.UpdatePlanetRequest
import br.com.lteixeira.msplanet.api.model.UpdatedPlanetResponse
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

interface UpdatePlanetApi {
    @Tag(name = "API Planetas")
    @Operation(summary = "Atualizar planetas")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Planeta atualizado com sucesso"),
        ApiResponse(responseCode = "400", description = "Atributos inválidos"),
        ApiResponse(responseCode = "422", description = "Planeta já existe outro planeta cadastrado na base com mesmo nome")
    ])
    @PutMapping("planets/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable("id") id: String,
        @Valid @RequestBody updatePlanetRequest: UpdatePlanetRequest
    ): UpdatedPlanetResponse
}