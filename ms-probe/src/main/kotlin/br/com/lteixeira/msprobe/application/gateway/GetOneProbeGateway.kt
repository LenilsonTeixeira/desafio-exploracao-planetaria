package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.GetOneProbeDomain

interface GetOneProbeGateway {
    fun getOne(name: String): GetOneProbeDomain?
}