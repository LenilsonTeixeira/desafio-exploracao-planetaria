package br.com.lteixeira.msplanet.application.validator.validation

import br.com.lteixeira.msplanet.application.exception.PlanetAlreadyExistsException
import br.com.lteixeira.msplanet.application.usecase.UpdatePlanetExistsUseCase
import br.com.lteixeira.msplanet.application.validator.Validator
import br.com.lteixeira.msplanet.domain.UpdatePlanetDomain
import org.springframework.stereotype.Component

@Component
class UpdatePlanetAlreadyExistsValidation(private val updatePlanetExistsUseCase: UpdatePlanetExistsUseCase):
    Validator<UpdatePlanetDomain> {
    override fun validate(planet: UpdatePlanetDomain) {
        val exists = updatePlanetExistsUseCase.execute(planet.name, planet.externalId)
        if (exists) {
            throw PlanetAlreadyExistsException("Não é possível atualizar planeta com o nome ${planet.name}. Motivo: Já existe outro planeta cadastrado com esse mesmo nome.")
        }
    }
}