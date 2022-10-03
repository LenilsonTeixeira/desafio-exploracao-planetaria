package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.converter.toProbe
import br.com.lteixeira.msprobe.application.exception.AddProbeCommandException
import br.com.lteixeira.msprobe.application.gateway.AddProbeCommandGateway
import br.com.lteixeira.msprobe.application.strategy.ProbeDirectionStrategyExecutor
import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain
import br.com.lteixeira.msprobe.domain.AddedProbeCommandDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AddProbeCommandUseCase(
    private val probeDirectionStrategyExecutor: ProbeDirectionStrategyExecutor,
    private val getOneProbeUseCase: GetOneProbeUseCase,
    private val publishProbeMessageUseCase: PublishProbeMessageUseCase,
    private val addProbeCommandGateway: AddProbeCommandGateway
) {
    companion object {
        private val log = LoggerFactory.getLogger(AddProbeCommandUseCase::class.java)
    }

    fun execute(addProbeCommandDomain: AddProbeCommandDomain): AddedProbeCommandDomain {
        runCatching {
            log.info("Adicionando os seguintes comandos: [${addProbeCommandDomain.command} | direção: ${addProbeCommandDomain.direction}] a sonda: ${addProbeCommandDomain.probeEntity?.name}")
            val probe = getOneProbeUseCase.execute(addProbeCommandDomain.probeName)
            addProbeCommandDomain.probeEntity = probe
            val probeDirection = probeDirectionStrategyExecutor.execute(addProbeCommandDomain)
            val addedProbeCommand =  addProbeCommandGateway.addCommand(probeDirection)
            publishProbeMessageUseCase.execute(probeDirection.toProbe(addProbeCommandDomain.planet))
            return addedProbeCommand
        }.getOrElse {
            log.error("Falha ao enviar comandos para a sonda: ${addProbeCommandDomain.probeEntity?.name}")
            throw AddProbeCommandException("Ocorreu um erro ao enviar comandos a sonda: ${addProbeCommandDomain.probeEntity?.name}")
        }
    }
}