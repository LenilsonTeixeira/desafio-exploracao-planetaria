package br.com.lteixeira.msplanet.application.gateway.database

import br.com.lteixeira.msplanet.application.gateway.AddPlanetExistsGateway
import br.com.lteixeira.msplanet.application.gateway.database.repository.PlanetRepository
import org.springframework.stereotype.Service

@Service
class AddPlanetExistsGatewayImpl(private val planetRepository: PlanetRepository): AddPlanetExistsGateway {

    override fun existsByName(name: String): Boolean {
        return planetRepository.existsByName(name)
    }
}