package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.GetProbeDomain

interface GetProbeGateway {
    fun getByExternalId(externalId: String): GetProbeDomain?
}