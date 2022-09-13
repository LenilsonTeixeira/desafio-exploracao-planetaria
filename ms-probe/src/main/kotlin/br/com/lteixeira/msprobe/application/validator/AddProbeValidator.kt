package br.com.lteixeira.msprobe.application.validator

import br.com.lteixeira.msprobe.application.validator.validation.AddProbeAlreadyExistsValidation
import br.com.lteixeira.msprobe.domain.AddProbeDomain
import org.springframework.stereotype.Component

@Component
class AddProbeValidator(addProbeAlreadyExistsValidation: AddProbeAlreadyExistsValidation) {
    private val validations = listOf<Validator<AddProbeDomain>>(addProbeAlreadyExistsValidation)

    fun validate(planetDomain: AddProbeDomain) {
        validations.forEach {
            it.validate(planetDomain)
        }
    }
}