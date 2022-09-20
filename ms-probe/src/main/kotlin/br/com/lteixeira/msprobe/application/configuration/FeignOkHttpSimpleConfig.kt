package br.com.lteixeira.msprobe.application.configuration

import feign.Logger
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.concurrent.TimeUnit

@Component
class FeignOkHttpSimpleConfig {

    companion object {
        private const val KEEP_ALIVE_DURATION = 5
    }

    @Value("\${feign.okhttp.readTimeout:5000}")
    private val readTimeout: Long = 5000

    @Value("\${feign.okhttp.connectTimeout:5000}")
    private val connectTimeout: Long = 5000

    @Value("\${feign.okhttp.maxIdleConnections:50}")
    private val maxIdleConnections: Int = 50

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }

    @Bean
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .readTimeout(Duration.ofSeconds(readTimeout))
            .connectTimeout(Duration.ofSeconds(connectTimeout))
            .connectionPool(ConnectionPool(maxIdleConnections, KEEP_ALIVE_DURATION.toLong(), TimeUnit.MINUTES))
            .build()
    }
}