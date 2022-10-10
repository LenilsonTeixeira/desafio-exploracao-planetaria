package br.com.lteixeira.msimpactanalyzer.configuration

import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestClientBuilder
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ElasticsearchConfiguration {
    @Value("\${elasticsearch.host}")
    private val host: String = "elasticsearch"

    @Value("\${elasticsearch.port}")
    private val port: Int = 9200

    @Bean(destroyMethod = "close")
    fun elasticsearchClient(): RestHighLevelClient {
        return RestHighLevelClient(restClientBuilder())
    }

    private fun restClientBuilder(): RestClientBuilder {
        return RestClient.builder(HttpHost(host, port))
    }
}