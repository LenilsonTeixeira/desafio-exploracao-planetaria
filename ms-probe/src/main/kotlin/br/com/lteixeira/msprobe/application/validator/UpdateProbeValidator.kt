package br.com.lteixeira.msprobe.application.validator

import br.com.lteixeira.msprobe.application.validator.validation.UpdateProbeAlreadyExistsValidation
import br.com.lteixeira.msprobe.domain.UpdateProbeDomain
import org.springframework.stereotype.Component

@Component
class UpdateProbeValidator(updateProbeAlreadyExistsValidation: UpdateProbeAlreadyExistsValidation) {
    private val validations = listOf<Validator<UpdateProbeDomain>>(updateProbeAlreadyExistsValidation)

    fun validate(probeDomain: UpdateProbeDomain) {
        validations.forEach {
            it.validate(probeDomain)
        }
    }
}