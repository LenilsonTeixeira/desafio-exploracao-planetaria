package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.gateway.GetAllPlanetsGateway
import br.com.lteixeira.msplanet.domain.GetAllPlanetsDomain
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class GetAllPlanetsUseCase(private val getAllPlanetsGateway: GetAllPlanetsGateway) {

    fun execute(page: Int, size: Int): Page<GetAllPlanetsDomain> {
        return getAllPlanetsGateway.getAll(page, size)
    }
}