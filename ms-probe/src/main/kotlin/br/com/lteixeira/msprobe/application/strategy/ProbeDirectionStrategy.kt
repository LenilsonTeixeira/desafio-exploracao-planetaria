package br.com.lteixeira.msprobe.application.strategy

import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain

interface ProbeDirectionStrategy {
    fun getDirection(probe: AddProbeCommandDomain): AddProbeCommandDomain
}