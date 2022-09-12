package br.com.lteixeira.msplanet.application.controller

import br.com.lteixeira.msplanet.api.UpdatePlanetApi
import br.com.lteixeira.msplanet.api.model.UpdatePlanetRequest
import br.com.lteixeira.msplanet.api.model.UpdatedPlanetResponse
import br.com.lteixeira.msplanet.application.converter.toUpdatePlanetDomain
import br.com.lteixeira.msplanet.application.converter.toUpdatedPlanetResponse
import br.com.lteixeira.msplanet.application.usecase.UpdatePlanetUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UpdatePlanetController(private val updatePlanetUseCase: UpdatePlanetUseCase) : UpdatePlanetApi {

    override fun update(
        @PathVariable("id") id: String,
        @Valid @RequestBody updatePlanetRequest: UpdatePlanetRequest
    ): UpdatedPlanetResponse {
        val request = updatePlanetRequest.toUpdatePlanetDomain(id)
        return updatePlanetUseCase.execute(id, request).toUpdatedPlanetResponse()
    }
}