package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.converter.toAddedProbeCommandDomain
import br.com.lteixeira.msprobe.application.converter.toProbeCommandEntity
import br.com.lteixeira.msprobe.application.gateway.AddProbeCommandGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeCommandRepository
import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain
import br.com.lteixeira.msprobe.domain.AddedProbeCommandDomain
import org.springframework.stereotype.Service

@Service
class AddProbeCommandGatewayImpl(private val probeCommandRepository: ProbeCommandRepository): AddProbeCommandGateway {
    override fun addCommand(addProbeCommandDomain: AddProbeCommandDomain): AddedProbeCommandDomain {
        val probeCommand = addProbeCommandDomain.toProbeCommandEntity()
        return probeCommandRepository.save(probeCommand).toAddedProbeCommandDomain()
    }
}