package br.com.lteixeira.msprobe.domain

data class GetProbeCollisionDomain(
    val totalElements: Long,
    val probes: List<ProbeCollision>
)

data class ProbeCollision(
    val planet: String,
    val probe: String,
    val locationY: Int,
    val locationX: Int,
)