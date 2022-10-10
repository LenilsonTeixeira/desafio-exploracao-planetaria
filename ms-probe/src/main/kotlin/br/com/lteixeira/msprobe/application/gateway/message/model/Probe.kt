package br.com.lteixeira.msprobe.application.gateway.message.model

import br.com.lteixeira.msprobe.application.enumeration.Status

data class Probe(
    val id: String,
    val planet: String,
    val probe: String,
    val probeCoordinate: ProbeCoordinate,
    val status: Status
)

data class ProbeCoordinate(
    val locationX: Int,
    val locationY: Int,
)
