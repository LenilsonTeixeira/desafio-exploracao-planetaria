package br.com.lteixeira.msprobe.application.gateway.message.model

data class Probe(
    val planet: String,
    val probe: String,
    val probeLandingCoordinate: ProbeLandingCoordinate
)

data class ProbeLandingCoordinate(
    val locationX: Int,
    val locationY: Int,
)
