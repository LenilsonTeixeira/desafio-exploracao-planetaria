package br.com.lteixeira.msplanet.application.gateway.database

import br.com.lteixeira.msplanet.application.gateway.GetOnePlanetGateway
import br.com.lteixeira.msplanet.application.gateway.database.repository.PlanetRepository
import br.com.lteixeira.msplanet.application.gateway.toGetOnePlanetDomain
import br.com.lteixeira.msplanet.domain.GetOnePlanetDomain
import org.springframework.stereotype.Service

@Service
class GetOnePlanetGatewayImpl(private val planetRepository: PlanetRepository): GetOnePlanetGateway {

    override fun getOne(name: String): GetOnePlanetDomain? {
        return planetRepository.findByName(name)?.toGetOnePlanetDomain()
    }
}