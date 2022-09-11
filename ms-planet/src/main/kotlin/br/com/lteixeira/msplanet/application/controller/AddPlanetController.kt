package br.com.lteixeira.msplanet.application.controller

import br.com.lteixeira.msplanet.api.AddPlanetApi
import br.com.lteixeira.msplanet.api.model.AddPlanetRequest
import br.com.lteixeira.msplanet.api.model.AddedPlanetResponse
import br.com.lteixeira.msplanet.application.converter.toAddPlanetDomain
import br.com.lteixeira.msplanet.application.converter.toAddedPlanetResponse
import br.com.lteixeira.msplanet.application.usecase.AddPlanetUseCase
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class AddPlanetController(private val addPlanetUseCase: AddPlanetUseCase) : AddPlanetApi {

    override fun add(@Valid @RequestBody addPlanetRequest: AddPlanetRequest): AddedPlanetResponse {
        val request = addPlanetRequest.toAddPlanetDomain()
        return addPlanetUseCase.execute(request).toAddedPlanetResponse()
    }
}