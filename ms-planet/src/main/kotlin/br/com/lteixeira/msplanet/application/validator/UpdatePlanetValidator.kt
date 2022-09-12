package br.com.lteixeira.msplanet.application.validator

import br.com.lteixeira.msplanet.application.validator.validation.UpdatePlanetAlreadyExistsValidation
import br.com.lteixeira.msplanet.domain.UpdatePlanetDomain
import org.springframework.stereotype.Component

@Component
class UpdatePlanetValidator(updatePlanetAlreadyExistsValidation: UpdatePlanetAlreadyExistsValidation) {
    private val validations = listOf<Validator<UpdatePlanetDomain>>(updatePlanetAlreadyExistsValidation)

    fun validate(planetDomain: UpdatePlanetDomain) {
        validations.forEach {
            it.validate(planetDomain)
        }
    }
}