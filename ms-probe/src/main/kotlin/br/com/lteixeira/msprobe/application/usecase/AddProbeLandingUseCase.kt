package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.exception.AddProbeLandingException
import br.com.lteixeira.msprobe.application.gateway.AddProbeLandingGateway
import br.com.lteixeira.msprobe.application.validator.validation.ProbeLandingCartesianCoordinateValidation
import br.com.lteixeira.msprobe.domain.AddProbeLandingDomain
import br.com.lteixeira.msprobe.domain.AddedProbeLandingDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AddProbeLandingUseCase(
    private val getOneProbeUseCase: GetOneProbeUseCase,
    private val getPlanetUseCase: GetPlanetUseCase,
    private val addProbeLandingGateway: AddProbeLandingGateway
) {
    companion object {
        private val log = LoggerFactory.getLogger(AddProbeLandingUseCase::class.java)
    }

    fun execute(addProbeLandingDomain: AddProbeLandingDomain): AddedProbeLandingDomain {
        log.info("Obtendo informações da sonda: ${addProbeLandingDomain.probeName}")
        val probe = getOneProbeUseCase.execute(addProbeLandingDomain.probeName)
        addProbeLandingDomain.probeEntityDomain = probe

        log.info("Obtendo informações do planeta: ${addProbeLandingDomain.planet}")
        val planet = getPlanetUseCase.execute(addProbeLandingDomain.planet)

        log.info("Validando informações de pouso da sonda: ${addProbeLandingDomain.probeName}")
        ProbeLandingCartesianCoordinateValidation.validate(planet.cartesianCoordinateSystemArea, addProbeLandingDomain)

        runCatching {
            log.info("Registrando pouso da sonda: ${probe.name} no planeta: ${addProbeLandingDomain.planet}")
            return addProbeLandingGateway.addLanding(addProbeLandingDomain)
        }.getOrElse {
            log.error("Falha na tentativa de pousar a sonda: ${probe.name} no planeta: ${addProbeLandingDomain.planet}. Erro: $it")
            throw AddProbeLandingException("Ocorreu um problema na tentativa de pouso da sonda: ${probe.name} no planeta: ${addProbeLandingDomain.planet}")
        }
    }
}