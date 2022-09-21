package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.exception.GetPlanetException
import br.com.lteixeira.msprobe.application.gateway.GetPlanetGateway
import br.com.lteixeira.msprobe.domain.GetPlanetDomain
import org.springframework.stereotype.Component

@Component
class GetPlanetUseCase(private val getPlanetGateway: GetPlanetGateway) {
    fun execute(name: String): GetPlanetDomain {
        return getPlanetGateway.getPlanet(name) ?: throw GetPlanetException("Planeta ${name} não encontrado.")
    }
}