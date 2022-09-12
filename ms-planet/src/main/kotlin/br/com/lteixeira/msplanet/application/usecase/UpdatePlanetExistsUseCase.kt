package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.gateway.UpdatePlanetExistsGateway
import org.springframework.stereotype.Component

@Component
class UpdatePlanetExistsUseCase(private val updatePlanetExistsGateway: UpdatePlanetExistsGateway) {

    fun execute(name: String, externalId: String): Boolean {
        return updatePlanetExistsGateway.existsByNameAndExternalIdNotLike(name, externalId)
    }
}