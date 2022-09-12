package br.com.lteixeira.msplanet.application.controller

import br.com.lteixeira.msplanet.api.GetAllPlanetsApi
import br.com.lteixeira.msplanet.api.model.GetAllPlanetsResponse
import br.com.lteixeira.msplanet.application.converter.toGetAllPlanetsResponse
import br.com.lteixeira.msplanet.application.usecase.GetAllPlanetsUseCase
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GetAllPlanetsController(private val getAllPlanetsUseCase: GetAllPlanetsUseCase): GetAllPlanetsApi {

    override fun getAll(@RequestParam("page") page: Int, @RequestParam("size") size: Int): Page<GetAllPlanetsResponse> {
        return getAllPlanetsUseCase.execute(page, size).map { it.toGetAllPlanetsResponse() }
    }
}