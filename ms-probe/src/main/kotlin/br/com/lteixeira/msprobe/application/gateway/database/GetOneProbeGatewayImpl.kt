package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.gateway.GetOneProbeGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeRepository
import br.com.lteixeira.msprobe.application.toGetOneProbeDomain
import br.com.lteixeira.msprobe.domain.GetOneProbeDomain
import org.springframework.stereotype.Service

@Service
class GetOneProbeGatewayImpl(private val probeRepository: ProbeRepository): GetOneProbeGateway {
    override fun getOne(name: String): GetOneProbeDomain? {
        return probeRepository.findByName(name)?.toGetOneProbeDomain()
    }
}