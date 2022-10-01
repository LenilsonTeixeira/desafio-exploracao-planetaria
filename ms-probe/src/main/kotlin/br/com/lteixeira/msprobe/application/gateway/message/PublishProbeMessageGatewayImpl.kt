package br.com.lteixeira.msprobe.application.gateway.message

import br.com.lteixeira.msprobe.application.gateway.PublishProbeMessageGateway
import br.com.lteixeira.msprobe.application.gateway.message.model.Probe
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class PublishProbeMessageGatewayImpl(private val kafkaTemplate: KafkaTemplate<String, Any>) : PublishProbeMessageGateway {
    @Value("\${kafka.topics.probe}")
    private val topic: String = "probe"

    companion object {
        private val log = LoggerFactory.getLogger(PublishProbeMessageGatewayImpl::class.java)
    }

    override fun publish(probe: Probe) {
        log.info("Preparando para enviar mensagem para o Kafka. Payload: {}", probe)
        val message: Message<Probe> = MessageBuilder
            .withPayload(probe)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build()
        kafkaTemplate.send(message)
    }
}