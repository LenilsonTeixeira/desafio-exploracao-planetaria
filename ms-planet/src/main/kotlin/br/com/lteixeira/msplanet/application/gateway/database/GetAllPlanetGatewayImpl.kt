package br.com.lteixeira.msplanet.application.gateway.database

import br.com.lteixeira.msplanet.application.converter.toGetAllPlanetsDomain
import br.com.lteixeira.msplanet.application.gateway.GetAllPlanetsGateway
import br.com.lteixeira.msplanet.application.gateway.database.repository.PlanetRepository
import br.com.lteixeira.msplanet.domain.GetAllPlanetsDomain
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class GetAllPlanetGatewayImpl(private val planetRepository: PlanetRepository) : GetAllPlanetsGateway {

    override fun getAll(page: Int, size: Int): Page<GetAllPlanetsDomain> {
        return planetRepository.findAll(PageRequest.of(page, size)).map { it.toGetAllPlanetsDomain() }
    }
}