package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.GetProbeCollisionDomain
import br.com.lteixeira.msprobe.domain.SearchProbeCollisionDomain

interface GetProbeCollisionGateway {
    fun getProbes(searchProbeCollisionDomain: SearchProbeCollisionDomain): GetProbeCollisionDomain
}