package br.com.lteixeira.msplanet.application.gateway

import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import br.com.lteixeira.msplanet.domain.AddedPlanetDomain

interface AddPlanetGateway {
    fun add(addPlanetDomain: AddPlanetDomain): AddedPlanetDomain
}