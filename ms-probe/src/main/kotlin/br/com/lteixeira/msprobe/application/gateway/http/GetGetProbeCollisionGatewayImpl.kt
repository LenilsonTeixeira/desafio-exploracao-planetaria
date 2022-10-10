package br.com.lteixeira.msprobe.application.gateway.http

import br.com.lteixeira.msprobe.application.converter.toGetProbeCollisionDomain
import br.com.lteixeira.msprobe.application.gateway.GetProbeCollisionGateway
import br.com.lteixeira.msprobe.application.gateway.http.client.GetProbeCollisionHttpClient
import br.com.lteixeira.msprobe.domain.GetProbeCollisionDomain
import br.com.lteixeira.msprobe.domain.SearchProbeCollisionDomain
import org.springframework.stereotype.Service

@Service
class GetGetProbeCollisionGatewayImpl(private val getProbeCollisionHttpClient: GetProbeCollisionHttpClient) :
    GetProbeCollisionGateway {
    override fun getProbes(searchProbeCollisionDomain: SearchProbeCollisionDomain): GetProbeCollisionDomain {
        return getProbeCollisionHttpClient.get(
            planet = searchProbeCollisionDomain.planet,
            probe = searchProbeCollisionDomain.probe,
            locationX = searchProbeCollisionDomain.locationX,
            locationY = searchProbeCollisionDomain.locationY
        ).toGetProbeCollisionDomain()
    }
}