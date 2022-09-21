package br.com.lteixeira.msprobe.application.gateway.http.client

import br.com.lteixeira.msprobe.application.configuration.FeignOkHttpSimpleConfig
import br.com.lteixeira.msprobe.application.gateway.http.model.GetPlanetResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    value = "getPlanetHttpClient",
    url = "\${services.planet.url}",
    configuration = [FeignOkHttpSimpleConfig::class]
)
interface GetPlanetHttpClient {
    @GetMapping("/planets/{name}")
    fun get(@PathVariable("name") name: String): GetPlanetResponse?
}