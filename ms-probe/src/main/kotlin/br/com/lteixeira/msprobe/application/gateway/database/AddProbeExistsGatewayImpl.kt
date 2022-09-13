package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.gateway.AddProbeExistsGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeRepository
import org.springframework.stereotype.Service

@Service
class AddProbeExistsGatewayImpl(private val probeRepository: ProbeRepository): AddProbeExistsGateway {
    override fun existsByName(name: String): Boolean {
        return probeRepository.existsByName(name)
    }
}