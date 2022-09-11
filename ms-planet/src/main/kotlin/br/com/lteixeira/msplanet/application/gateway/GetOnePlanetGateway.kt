package br.com.lteixeira.msplanet.application.gateway

import br.com.lteixeira.msplanet.domain.GetOnePlanetDomain

interface GetOnePlanetGateway {

    fun getOne(name: String): GetOnePlanetDomain?
}