package br.com.lteixeira.msplanet.application.gateway.database

import br.com.lteixeira.msplanet.application.converter.toGetPlanetDomain
import br.com.lteixeira.msplanet.application.gateway.GetPlanetGateway
import br.com.lteixeira.msplanet.application.gateway.database.repository.PlanetRepository
import br.com.lteixeira.msplanet.domain.GetPlanetDomain
import org.springframework.stereotype.Service

@Service
class GetPlanetGatewayImpl(private val planetRepository: PlanetRepository): GetPlanetGateway {

    override fun getByExternalId(externalId: String): GetPlanetDomain? {
        return planetRepository.findByExternalId(externalId)?.toGetPlanetDomain()
    }
}