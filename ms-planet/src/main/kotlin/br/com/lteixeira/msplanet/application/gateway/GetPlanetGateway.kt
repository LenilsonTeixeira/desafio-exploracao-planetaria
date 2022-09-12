package br.com.lteixeira.msplanet.application.gateway

import br.com.lteixeira.msplanet.domain.GetPlanetDomain

interface GetPlanetGateway {
    fun getByExternalId(externalId: String): GetPlanetDomain?
}