package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.gateway.AddPlanetExistsGateway
import org.springframework.stereotype.Component

@Component
class AddPlanetExistsUseCase(private val addPlanetExistsGateway: AddPlanetExistsGateway) {

    fun execute(name: String): Boolean {
        return addPlanetExistsGateway.existsByName(name)
    }
}