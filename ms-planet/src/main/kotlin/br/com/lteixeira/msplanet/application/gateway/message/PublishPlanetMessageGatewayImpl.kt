package br.com.lteixeira.msplanet.application.gateway.message

import br.com.lteixeira.msplanet.application.gateway.PublishPlanetMessageGateway
import org.springframework.messaging.Message
import br.com.lteixeira.msplanet.application.gateway.message.model.Planet
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class PublishPlanetMessageGatewayImpl(private val kafkaTemplate: KafkaTemplate<String, Any>) : PublishPlanetMessageGateway {

    @Value("\${kafka.topics.planet}")
    private val topic: String = "planet"

    companion object {
        private val log = LoggerFactory.getLogger(PublishPlanetMessageGatewayImpl::class.java)
    }

    override fun publish(planet: Planet) {
        log.info("Preparando para enviar mensagem para o Kafka. Payload: {}", planet)
        val message: Message<Planet> = MessageBuilder
            .withPayload(planet)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build()
        kafkaTemplate.send(message)
    }
}