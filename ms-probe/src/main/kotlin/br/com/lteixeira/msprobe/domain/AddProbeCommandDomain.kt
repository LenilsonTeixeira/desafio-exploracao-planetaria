package br.com.lteixeira.msprobe.domain

import br.com.lteixeira.msprobe.application.enumeration.Direction

data class AddProbeCommandDomain(
    val command: String,
    var direction: Direction,
    val probeName: String,
    val planet: String,
    var probeEntity: GetOneProbeDomain? = null,
    var probeCommandCoordinate: AddProbeCommandCoordinateDomain? = null
)

data class AddProbeCommandCoordinateDomain(
    var locationX: Int,
    var locationY: Int,
)