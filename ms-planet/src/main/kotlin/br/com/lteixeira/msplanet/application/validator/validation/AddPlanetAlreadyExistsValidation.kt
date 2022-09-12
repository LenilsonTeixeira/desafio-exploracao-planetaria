package br.com.lteixeira.msplanet.application.validator.validation

import br.com.lteixeira.msplanet.application.exception.PlanetAlreadyExistsException
import br.com.lteixeira.msplanet.application.usecase.AddPlanetExistsUseCase
import br.com.lteixeira.msplanet.application.validator.Validator
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import org.springframework.stereotype.Component

@Component
class AddPlanetAlreadyExistsValidation(private val addPlanetExistsUseCase: AddPlanetExistsUseCase) :
    Validator<AddPlanetDomain> {

    override fun validate(planet: AddPlanetDomain) {
        val exists = addPlanetExistsUseCase.execute(planet.name)
        if (exists) {
            throw PlanetAlreadyExistsException("Não é possível cadastrar um novo planeta com o nome ${planet.name}, porque já existe um planeta com mesmo nome cadastrado na base")
        }
    }
}