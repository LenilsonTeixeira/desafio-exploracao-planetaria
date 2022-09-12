package br.com.lteixeira.msplanet.application.validator

import br.com.lteixeira.msplanet.application.validator.validation.AddPlanetAlreadyExistsValidation
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import org.springframework.stereotype.Component

@Component
class AddPlanetValidator(addPlanetAlreadyExistsValidation: AddPlanetAlreadyExistsValidation) {
    private val validations = listOf<Validator<AddPlanetDomain>>(addPlanetAlreadyExistsValidation)

    fun validate(planetDomain: AddPlanetDomain) {
        validations.forEach {
            it.validate(planetDomain)
        }
    }
}