package br.com.lteixeira.msplanet.application.gateway.database

import br.com.lteixeira.msplanet.application.converter.toPlanetDocument
import br.com.lteixeira.msplanet.application.converter.toUpdatedPlanetDomain
import br.com.lteixeira.msplanet.application.gateway.UpdatePlanetGateway
import br.com.lteixeira.msplanet.application.gateway.database.repository.PlanetRepository
import br.com.lteixeira.msplanet.domain.UpdatePlanetDomain
import br.com.lteixeira.msplanet.domain.UpdatedPlanetDomain
import org.springframework.stereotype.Service

@Service
class UpdatePlanetGatewayImpl(private val planetRepository: PlanetRepository): UpdatePlanetGateway {
    override fun update(updatePlanetDomain: UpdatePlanetDomain): UpdatedPlanetDomain {
        val planet = updatePlanetDomain.toPlanetDocument()
        return planetRepository.save(planet).toUpdatedPlanetDomain()
    }
}