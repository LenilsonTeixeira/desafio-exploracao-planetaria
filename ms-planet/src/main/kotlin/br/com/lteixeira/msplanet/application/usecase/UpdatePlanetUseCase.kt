package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.exception.UpdatePlanetException
import br.com.lteixeira.msplanet.application.gateway.UpdatePlanetGateway
import br.com.lteixeira.msplanet.application.gateway.message.model.Planet
import br.com.lteixeira.msplanet.application.validator.UpdatePlanetValidator
import br.com.lteixeira.msplanet.domain.UpdatePlanetDomain
import br.com.lteixeira.msplanet.domain.UpdatedPlanetDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class UpdatePlanetUseCase(
    private val updatePlanetValidator: UpdatePlanetValidator,
    private val getPlanetUseCase: GetPlanetUseCase,
    private val publishPlanetMessageUseCase: PublishPlanetMessageUseCase,
    private val updatePlanetGateway: UpdatePlanetGateway,
    ) {

    companion object {
        private val log = LoggerFactory.getLogger(UpdatePlanetUseCase::class.java)
    }

    fun execute(id: String, updatePlanetDomain: UpdatePlanetDomain): UpdatedPlanetDomain {
        log.info("Executando regras de validação para atualização de planeta");
        updatePlanetValidator.validate(updatePlanetDomain)

        val planet = getPlanetUseCase.execute(id)

        runCatching {
            updatePlanetDomain.id = planet.id
            log.info("Preparando para atualizar planeta com id: $id")
            val planet = updatePlanetGateway.update(updatePlanetDomain)
            publishPlanetMessageUseCase.execute(planet = Planet(planet.name, planet.cartesianCoordinateSystemArea))
            return planet
        }.getOrElse {
            log.error("Falha ao atualizar planeta ${updatePlanetDomain}. Erro: $it")
            throw UpdatePlanetException("Falha ao atualizar planeta com id: $id")
        }
    }
}