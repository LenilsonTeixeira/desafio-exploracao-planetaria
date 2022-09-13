package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.gateway.UpdateProbeGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeRepository
import br.com.lteixeira.msprobe.application.toProbeDocument
import br.com.lteixeira.msprobe.application.toUpdatedProbeDomain
import br.com.lteixeira.msprobe.domain.UpdateProbeDomain
import br.com.lteixeira.msprobe.domain.UpdatedProbeDomain
import org.springframework.stereotype.Service

@Service
class UpdateProbeGatewayImpl(private val probeRepository: ProbeRepository): UpdateProbeGateway {
    override fun update(updateProbeDomain: UpdateProbeDomain): UpdatedProbeDomain {
        val probe = updateProbeDomain.toProbeDocument()
        return probeRepository.save(probe).toUpdatedProbeDomain()
    }
}