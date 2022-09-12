package br.com.lteixeira.msplanet.api

import br.com.lteixeira.msplanet.api.model.GetAllPlanetsResponse
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

interface GetAllPlanetsApi {
    @GetMapping("planets")
    @ResponseStatus(HttpStatus.OK)
    fun getAll(@RequestParam("page") page: Int, @RequestParam("size") size: Int): Page<GetAllPlanetsResponse>
}