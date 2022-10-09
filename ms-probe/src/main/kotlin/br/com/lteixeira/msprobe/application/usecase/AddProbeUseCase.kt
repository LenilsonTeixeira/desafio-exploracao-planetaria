package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.exception.AddProbeException
import br.com.lteixeira.msprobe.application.gateway.AddProbeGateway
import br.com.lteixeira.msprobe.application.helper.MetricHelper.PROBES_TOTAL
import br.com.lteixeira.msprobe.application.instrument.Counter
import br.com.lteixeira.msprobe.application.validator.AddProbeValidator
import br.com.lteixeira.msprobe.domain.AddProbeDomain
import br.com.lteixeira.msprobe.domain.AddedProbeDomain
import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AddProbeUseCase(
    private val addProbeValidator: AddProbeValidator,
    private val meterRegistry: MeterRegistry,
    private val addProbeGateway: AddProbeGateway) {

    companion object {
        private val log = LoggerFactory.getLogger(AddProbeUseCase::class.java)
    }

    fun execute(addProbeDomain: AddProbeDomain): AddedProbeDomain {
        log.info("Executando regras de validação para cadastro de sondas");
        addProbeValidator.validate(addProbeDomain)

        runCatching {
            log.info("Preparando para cadastrar sonda: ${addProbeDomain.name}")
            val probe = addProbeGateway.add(addProbeDomain)
            Counter(meterRegistry).count(PROBES_TOTAL)
            return probe
        }.getOrElse {
            log.error("Falha ao salvar sonda: ${addProbeDomain.name}. Erro: $it")
            throw AddProbeException("Ocorreu um erro ao salvar sonda: ${addProbeDomain.name}")
        }
    }
}