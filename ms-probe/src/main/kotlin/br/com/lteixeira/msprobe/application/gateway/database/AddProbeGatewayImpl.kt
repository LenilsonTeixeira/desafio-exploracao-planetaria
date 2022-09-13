package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.gateway.AddProbeGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeRepository
import br.com.lteixeira.msprobe.application.toAddedProbeDomain
import br.com.lteixeira.msprobe.application.toProbeDocument
import br.com.lteixeira.msprobe.domain.AddProbeDomain
import br.com.lteixeira.msprobe.domain.AddedProbeDomain
import org.springframework.stereotype.Component

@Component
class AddProbeGatewayImpl(private val probeRepository: ProbeRepository): AddProbeGateway {
    override fun add(addProbeDomain: AddProbeDomain): AddedProbeDomain {
        val probe = addProbeDomain.toProbeDocument()
        return probeRepository.save(probe).toAddedProbeDomain()
    }
}