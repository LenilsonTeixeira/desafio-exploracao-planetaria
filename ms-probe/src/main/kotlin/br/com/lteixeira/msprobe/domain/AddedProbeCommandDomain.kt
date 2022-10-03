package br.com.lteixeira.msprobe.domain

data class AddedProbeCommandDomain(
    val planet: String,
    val command: String,
    val direction: String,
    val probeCommandCoordinate: AddedProbeCommandCoordinateDomain
)

data class AddedProbeCommandCoordinateDomain(
    val locationX: Int,
    val locationY: Int,
)