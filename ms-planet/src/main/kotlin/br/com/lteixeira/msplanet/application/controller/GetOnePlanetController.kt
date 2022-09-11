package br.com.lteixeira.msplanet.application.controller

import br.com.lteixeira.msplanet.api.GetOnePlanetApi
import br.com.lteixeira.msplanet.api.model.GetOnePlanetResponse
import br.com.lteixeira.msplanet.application.gateway.toGetOnePlanetResponse
import br.com.lteixeira.msplanet.application.usecase.GetOnePlanetUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetOnePlanetController(private val getOnePlanetUseCase: GetOnePlanetUseCase) : GetOnePlanetApi {

    override fun getOne(@PathVariable("name") name: String): GetOnePlanetResponse {
        return getOnePlanetUseCase.execute(name).toGetOnePlanetResponse()
    }
}