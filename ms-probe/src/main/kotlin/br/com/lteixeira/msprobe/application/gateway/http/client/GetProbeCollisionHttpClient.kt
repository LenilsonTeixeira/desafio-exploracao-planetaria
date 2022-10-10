package br.com.lteixeira.msprobe.application.gateway.http.client

import br.com.lteixeira.msprobe.application.configuration.FeignOkHttpSimpleConfig
import br.com.lteixeira.msprobe.application.gateway.http.model.GetProbeCollisionResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    value = "getProbeCollisionHttpClient",
    url = "\${services.impact-analyzer.url}",
    configuration = [FeignOkHttpSimpleConfig::class]
)
interface GetProbeCollisionHttpClient {
    @GetMapping("/probes/collision")
    fun get(
        @RequestParam("planet") planet: String,
        @RequestParam("probe") probe: String,
        @RequestParam("locationX") locationX: Int,
        @RequestParam("locationY") locationY: Int
    ): GetProbeCollisionResponse
}