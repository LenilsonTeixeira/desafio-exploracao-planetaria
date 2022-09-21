package br.com.lteixeira.msprobe.application.gateway.http

import br.com.lteixeira.msprobe.application.converter.toGetPlanetDomain
import br.com.lteixeira.msprobe.application.gateway.GetPlanetGateway
import br.com.lteixeira.msprobe.application.gateway.http.client.GetPlanetHttpClient
import br.com.lteixeira.msprobe.domain.GetPlanetDomain
import org.springframework.stereotype.Service

@Service
class GetPlanetGatewayImpl(private val getPlanetHttpClient: GetPlanetHttpClient): GetPlanetGateway {
    override fun getPlanet(name: String): GetPlanetDomain? {
        return getPlanetHttpClient.get(name)?.toGetPlanetDomain()
    }
}