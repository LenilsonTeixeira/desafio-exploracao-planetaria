package br.com.lteixeira.msplanet.application.gateway

import br.com.lteixeira.msplanet.domain.GetAllPlanetsDomain
import org.springframework.data.domain.Page

interface GetAllPlanetsGateway {
    fun getAll(page: Int, size: Int): Page<GetAllPlanetsDomain>
}