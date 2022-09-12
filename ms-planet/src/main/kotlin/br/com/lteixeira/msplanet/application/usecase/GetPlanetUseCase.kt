package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.exception.GetPlanetException
import br.com.lteixeira.msplanet.application.gateway.GetPlanetGateway
import br.com.lteixeira.msplanet.domain.GetPlanetDomain
import org.springframework.stereotype.Component

@Component
class GetPlanetUseCase(private val getPlanetGateway: GetPlanetGateway) {

    fun execute(externalId: String): GetPlanetDomain {
        return getPlanetGateway.getByExternalId(externalId)
            ?: throw GetPlanetException("Planeta com id: $externalId não encontrado")
    }
}