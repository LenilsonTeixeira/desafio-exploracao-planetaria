package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.UpdateProbeDomain
import br.com.lteixeira.msprobe.domain.UpdatedProbeDomain

interface UpdateProbeGateway {
    fun update(updateProbeDomain: UpdateProbeDomain): UpdatedProbeDomain
}