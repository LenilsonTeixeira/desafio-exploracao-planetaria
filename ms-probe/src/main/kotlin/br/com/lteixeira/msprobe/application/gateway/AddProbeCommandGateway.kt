package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain
import br.com.lteixeira.msprobe.domain.AddedProbeCommandDomain

interface AddProbeCommandGateway {
    fun addCommand(addProbeCommandDomain: AddProbeCommandDomain): AddedProbeCommandDomain
}