package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.GetPlanetDomain

interface GetPlanetGateway {
    fun getPlanet(name: String): GetPlanetDomain?
}