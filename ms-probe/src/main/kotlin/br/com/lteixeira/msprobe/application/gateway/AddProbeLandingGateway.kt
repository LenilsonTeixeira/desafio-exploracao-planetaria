package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.AddProbeLandingDomain
import br.com.lteixeira.msprobe.domain.AddedProbeLandingDomain

interface AddProbeLandingGateway {
    fun addLanding(addProbeLandingDomain: AddProbeLandingDomain): AddedProbeLandingDomain
}