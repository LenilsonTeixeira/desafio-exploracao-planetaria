package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.gateway.GetProbeCollisionGateway
import br.com.lteixeira.msprobe.domain.GetProbeCollisionDomain
import br.com.lteixeira.msprobe.domain.SearchProbeCollisionDomain
import org.springframework.stereotype.Component

@Component
class GetProbeCollisionUseCase(private val getProbeCollisionGateway: GetProbeCollisionGateway) {
    fun execute(searchProbeCollisionDomain: SearchProbeCollisionDomain): GetProbeCollisionDomain {
        return getProbeCollisionGateway.getProbes(searchProbeCollisionDomain)
    }
}