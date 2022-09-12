package br.com.lteixeira.msplanet.application.gateway.database

import br.com.lteixeira.msplanet.application.gateway.UpdatePlanetExistsGateway
import br.com.lteixeira.msplanet.application.gateway.database.repository.PlanetRepository
import org.springframework.stereotype.Service

@Service
class UpdatePlanetExistsGatewayImpl(private val planetRepository: PlanetRepository): UpdatePlanetExistsGateway{

    override fun existsByNameAndExternalIdNotLike(name: String, externalId: String): Boolean {
        return planetRepository.existsByNameAndExternalIdNotLike(name, externalId)
    }
}