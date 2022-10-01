package br.com.lteixeira.msprobe.application.gateway.message.serializer

import br.com.lteixeira.msprobe.application.gateway.message.model.Probe
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer
import org.slf4j.LoggerFactory

class ProbeSerializer : Serializer<Probe> {
    private val objectMapper = ObjectMapper()
    private val log = LoggerFactory.getLogger(ProbeSerializer::class.java)

    override fun serialize(topic: String?, data: Probe?): ByteArray? {
        log.info("Serializando objeto: {}", data)
        return objectMapper.writeValueAsBytes(
            data ?: throw SerializationException("Erro durante a serialização da sonda")
        )
    }

    override fun close() {}
}