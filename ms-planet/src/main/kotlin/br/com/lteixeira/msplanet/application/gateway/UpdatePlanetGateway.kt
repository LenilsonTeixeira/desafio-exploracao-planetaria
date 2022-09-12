package br.com.lteixeira.msplanet.application.gateway

import br.com.lteixeira.msplanet.domain.UpdatePlanetDomain
import br.com.lteixeira.msplanet.domain.UpdatedPlanetDomain

interface UpdatePlanetGateway {

    fun update(updatePlanetDomain: UpdatePlanetDomain): UpdatedPlanetDomain
}