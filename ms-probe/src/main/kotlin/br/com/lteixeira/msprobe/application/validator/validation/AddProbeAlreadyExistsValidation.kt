package br.com.lteixeira.msprobe.application.validator.validation

import br.com.lteixeira.msprobe.application.exception.ProbeAlreadyExistsException
import br.com.lteixeira.msprobe.application.usecase.AddProbeExistsUseCase
import br.com.lteixeira.msprobe.application.validator.Validator
import br.com.lteixeira.msprobe.domain.AddProbeDomain
import org.springframework.stereotype.Component

@Component
class AddProbeAlreadyExistsValidation(private val addProbeExistsUseCase: AddProbeExistsUseCase) :
    Validator<AddProbeDomain> {
    override fun validate(probe: AddProbeDomain) {
        val exists = addProbeExistsUseCase.execute(probe.name)
        if (exists) {
            throw ProbeAlreadyExistsException("Não é possível cadastrar uma nova sonda com o nome ${probe.name}, porque já existe uma sonda com o mesmo nome cadastrado na base")
        }
    }
}