package br.com.lteixeira.msprobe.application.gateway.http.model

data class GetProbeCollisionResponse(
    val totalElements: Long,
    val probes: List<ProbeCollisionResponse>
)

data class ProbeCollisionResponse(
    val planet: String,
    val probe: String,
    val locationY: Int,
    val locationX: Int,
    val status: String
)