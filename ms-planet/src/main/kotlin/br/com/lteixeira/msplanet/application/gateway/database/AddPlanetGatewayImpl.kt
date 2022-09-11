package br.com.lteixeira.msplanet.application.gateway.database

import br.com.lteixeira.msplanet.application.gateway.AddPlanetGateway
import br.com.lteixeira.msplanet.application.gateway.database.repository.PlanetRepository
import br.com.lteixeira.msplanet.application.gateway.toAddedPlanetDomain
import br.com.lteixeira.msplanet.application.gateway.toPlanetDocument
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import br.com.lteixeira.msplanet.domain.AddedPlanetDomain
import org.springframework.stereotype.Service

@Service
class AddPlanetGatewayImpl(val planetRepository: PlanetRepository) : AddPlanetGateway {

    override fun add(addPlanetDomain: AddPlanetDomain): AddedPlanetDomain {
        val planet = addPlanetDomain.toPlanetDocument()
        return planetRepository.save(planet).toAddedPlanetDomain()
    }
}