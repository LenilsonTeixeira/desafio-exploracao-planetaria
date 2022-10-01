package br.com.lteixeira.msprobe.application.configuration

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfig(
    @Value("\${kafka.bootstrapAddress}")
    private val servers: String,
    @Value("\${kafka.topics.probe}")
    private val topic: String
) {
    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any?> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = servers
        return KafkaAdmin(configs)
    }

    @Bean
    fun probe(): NewTopic {
        return NewTopic(topic, 1, 1.toShort())
    }
}