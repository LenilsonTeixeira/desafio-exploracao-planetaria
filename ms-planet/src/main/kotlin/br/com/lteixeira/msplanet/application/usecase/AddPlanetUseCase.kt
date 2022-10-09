package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.converter.toPlanet
import br.com.lteixeira.msplanet.application.exception.AddPlanetException
import br.com.lteixeira.msplanet.application.gateway.AddPlanetGateway
import br.com.lteixeira.msplanet.application.instrument.Counter
import br.com.lteixeira.msplanet.application.helper.MetricHelper.PLANETS_TOTAL
import br.com.lteixeira.msplanet.application.validator.AddPlanetValidator
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import br.com.lteixeira.msplanet.domain.AddedPlanetDomain
import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AddPlanetUseCase(
    private val addPlanetValidator: AddPlanetValidator,
    private val publishPlanetMessageUseCase: PublishPlanetMessageUseCase,
    private val addPlanetGateway: AddPlanetGateway,
    private val meterRegistry: MeterRegistry
) {
    companion object {
        private val log = LoggerFactory.getLogger(AddPlanetUseCase::class.java)
    }

    fun execute(addPlanetDomain: AddPlanetDomain): AddedPlanetDomain {
        log.info("Executando regras de validação para cadastro de planeta");
        addPlanetValidator.validate(addPlanetDomain)

        runCatching {
            log.info("Preparando para cadastrar planeta: ${addPlanetDomain.name}")
            val planet =  addPlanetGateway.add(addPlanetDomain)
            Counter(meterRegistry).count(PLANETS_TOTAL)
            publishPlanetMessageUseCase.execute(planet = planet.toPlanet())
            return planet
        }.getOrElse {
            log.error("Falha ao salvar planeta: ${addPlanetDomain.name}. Erro: $it")
            throw AddPlanetException("Ocorreu um erro ao salvar planeta: ${addPlanetDomain.name}")
        }
    }
}