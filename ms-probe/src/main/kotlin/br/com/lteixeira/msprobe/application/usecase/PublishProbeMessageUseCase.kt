package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.exception.PublishMessageException
import br.com.lteixeira.msprobe.application.gateway.PublishProbeMessageGateway
import br.com.lteixeira.msprobe.application.gateway.message.model.Probe
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PublishProbeMessageUseCase(private val publishProbeMessageGateway: PublishProbeMessageGateway) {
    companion object {
        private val log = LoggerFactory.getLogger(PublishProbeMessageUseCase::class.java)
    }

    fun execute(probe: Probe) {
        runCatching {
            publishProbeMessageGateway.publish(probe)
        }.getOrElse {
            log.error("Ocorreu um erro ao publicar mensagem no kafka. Payload: {} | Erro: {}", probe, it)
            throw PublishMessageException("Falha ao publicar mensagem no kafka.")
        }
    }
}