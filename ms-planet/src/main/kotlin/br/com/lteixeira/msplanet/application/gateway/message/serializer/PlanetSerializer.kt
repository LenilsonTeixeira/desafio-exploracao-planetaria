package br.com.lteixeira.msplanet.application.gateway.message.serializer

import br.com.lteixeira.msplanet.application.gateway.message.model.Planet
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer

class PlanetSerializer : Serializer<Planet> {
    private val objectMapper = ObjectMapper()
    private val log = LoggerFactory.getLogger(PlanetSerializer::class.java)

    override fun serialize(topic: String?, data: Planet?): ByteArray? {
        log.info("Serializando objeto: {}", data)
        return objectMapper.writeValueAsBytes(
            data ?: throw SerializationException("Erro durante a serialização de planeta")
        )
    }

    override fun close() {}
}