package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.gateway.GetProbeGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeRepository
import br.com.lteixeira.msprobe.application.converter.toGetProbeDomain
import br.com.lteixeira.msprobe.domain.GetProbeDomain
import org.springframework.stereotype.Service

@Service
class GetProbeGatewayImpl(private val probeRepository: ProbeRepository): GetProbeGateway {
    override fun getByExternalId(externalId: String): GetProbeDomain? {
        return probeRepository.findByExternalId(externalId)?.toGetProbeDomain()
    }
}