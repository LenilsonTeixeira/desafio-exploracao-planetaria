package br.com.lteixeira.msprobe.application.validator.validation

import br.com.lteixeira.msprobe.application.exception.ProbeAlreadyExistsException
import br.com.lteixeira.msprobe.application.usecase.UpdateProbeExistsUseCase
import br.com.lteixeira.msprobe.application.validator.Validator
import br.com.lteixeira.msprobe.domain.UpdateProbeDomain
import org.springframework.stereotype.Component

@Component
class UpdateProbeAlreadyExistsValidation(private val updateProbeExistsUseCase: UpdateProbeExistsUseCase) :
    Validator<UpdateProbeDomain> {
    override fun validate(probe: UpdateProbeDomain) {
        val exists = updateProbeExistsUseCase.execute(probe.name, probe.externalId)
        if (exists) {
            throw ProbeAlreadyExistsException("Não é possível atualizar sonda com o nome ${probe.name}, porque já existe outra sonda cadastrada com esse mesmo nome.")
        }
    }
}