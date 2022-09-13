package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.AddProbeDomain

import br.com.lteixeira.msprobe.domain.AddedProbeDomain

interface AddProbeGateway {
    fun add(addProbeDomain: AddProbeDomain): AddedProbeDomain
}