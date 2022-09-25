package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.exception.PublishMessageException
import br.com.lteixeira.msplanet.application.gateway.PublishPlanetMessageGateway
import br.com.lteixeira.msplanet.application.gateway.message.model.Planet
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PublishPlanetMessageUseCase(private val publishPlanetMessageGateway: PublishPlanetMessageGateway) {
    companion object {
        private val log = LoggerFactory.getLogger(PublishPlanetMessageUseCase::class.java)
    }

    fun execute(planet: Planet) {
        runCatching {
            publishPlanetMessageGateway.publish(planet)
        }.getOrElse {
            log.error("Ocorreu um erro ao publicar mensagem no kafka. Payload: {} | Erro: {}", planet, it)
            throw PublishMessageException("Falha ao publicar mensagem no kafka.")
        }
    }
}