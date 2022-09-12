package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.exception.GetPlanetException
import br.com.lteixeira.msplanet.application.gateway.GetOnePlanetGateway
import br.com.lteixeira.msplanet.domain.GetOnePlanetDomain
import org.springframework.stereotype.Component

@Component
class GetOnePlanetUseCase(private val getOnePlanetGateway: GetOnePlanetGateway) {

    fun execute(name: String): GetOnePlanetDomain {
        return getOnePlanetGateway.getOne(name) ?: throw GetPlanetException("Planeta: $name não encontrado")
    }
}