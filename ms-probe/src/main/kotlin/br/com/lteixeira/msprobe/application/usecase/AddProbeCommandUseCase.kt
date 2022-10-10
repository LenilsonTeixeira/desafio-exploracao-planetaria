package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.converter.toProbe
import br.com.lteixeira.msprobe.application.converter.toSearchProbeCollisionDomain
import br.com.lteixeira.msprobe.application.exception.AddProbeCommandException
import br.com.lteixeira.msprobe.application.exception.ProbeCollisionException
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
    private val processProbeImpactAnalyzerUseCase: ProcessProbeImpactAnalyzerUseCase,
    private val publishProbeMessageUseCase: PublishProbeMessageUseCase,
    private val addProbeCommandGateway: AddProbeCommandGateway
) {
    companion object {
        private val log = LoggerFactory.getLogger(AddProbeCommandUseCase::class.java)
    }

    fun execute(addProbeCommandDomain: AddProbeCommandDomain): AddedProbeCommandDomain {

        val probe = getOneProbeUseCase.execute(addProbeCommandDomain.probeName)
        addProbeCommandDomain.probeEntity = probe
        val probeDirection = probeDirectionStrategyExecutor.execute(addProbeCommandDomain)

        log.info("Processando analise de impacto da sonda: ${addProbeCommandDomain.probeName}")
        val result = processProbeImpactAnalyzerUseCase.execute(probeDirection.toSearchProbeCollisionDomain())

        if (result) {
            throw ProbeCollisionException("Impacto detectado! Não é possível prosseguir com o comando enviado para a sonda ${probeDirection.probeName} nessas coordenadas")
        }

        try {
            log.info("Adicionando os seguintes comandos: [${addProbeCommandDomain.command} | direção: ${addProbeCommandDomain.direction}] a sonda: ${addProbeCommandDomain.probeEntity?.name}")
            val addedProbeCommand =  addProbeCommandGateway.addCommand(probeDirection)
            publishProbeMessageUseCase.execute(probeDirection.toProbe(addProbeCommandDomain.planet))
            return addedProbeCommand
        } catch (e: ProbeCollisionException) {
            log.error("Falha ao salvar comandos da sonda: ${addProbeCommandDomain.probeEntity?.name}")
            throw AddProbeCommandException("Ocorreu um erro ao salvar comandos da sonda: ${addProbeCommandDomain.probeEntity?.name}")
        }
    }
}