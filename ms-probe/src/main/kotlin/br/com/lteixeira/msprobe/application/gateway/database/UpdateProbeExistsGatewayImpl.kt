package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.gateway.UpdateProbeExistsGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeRepository
import org.springframework.stereotype.Service

@Service
class UpdateProbeExistsGatewayImpl(private val probeRepository: ProbeRepository): UpdateProbeExistsGateway {
    override fun existsByNameAndExternalIdNotLike(name: String, externalId: String): Boolean {
        return probeRepository.existsByNameAndExternalIdNotLike(name, externalId)
    }
}