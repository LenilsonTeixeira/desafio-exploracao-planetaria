package br.com.lteixeira.msprobe.domain

import br.com.lteixeira.msprobe.application.enumeration.Direction

data class AddProbeLandingDomain(
    val probeName: String,
    var probeEntityDomain: GetOneProbeDomain? = null,
    val planet: String,
    val probeLandingCoordinate: AddProbeLandingCoordinateDomain
)

data class AddProbeLandingCoordinateDomain(
    val locationX: Int,
    val locationY: Int,
    val direction: Direction
)