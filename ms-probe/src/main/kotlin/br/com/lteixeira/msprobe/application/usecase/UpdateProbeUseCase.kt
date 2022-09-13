package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.exception.UpdateProbeException
import br.com.lteixeira.msprobe.application.gateway.UpdateProbeGateway
import br.com.lteixeira.msprobe.application.validator.UpdateProbeValidator
import br.com.lteixeira.msprobe.domain.UpdateProbeDomain
import br.com.lteixeira.msprobe.domain.UpdatedProbeDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class UpdateProbeUseCase(
    private val updateProbeValidator: UpdateProbeValidator,
    private val getProbeUseCase: GetProbeUseCase,
    private val updateProbeGateway: UpdateProbeGateway
) {

    companion object {
        private val log = LoggerFactory.getLogger(UpdateProbeUseCase::class.java)
    }

    fun execute(id: String, updateProbeDomain: UpdateProbeDomain): UpdatedProbeDomain {
        log.info("Executando regras de validação para atualização de sondas");
        updateProbeValidator.validate(updateProbeDomain)

        val probe = getProbeUseCase.execute(id)

        runCatching {
            updateProbeDomain.id = probe.id
            log.info("Preparando para atualizar sonda com id: $id")
            return updateProbeGateway.update(updateProbeDomain)
        }.getOrElse {
            log.error("Falha ao atualizar sonda ${updateProbeDomain.name}. Erro: $it")
            throw UpdateProbeException("Falha ao atualizar sonda com id: $id")
        }
    }
}