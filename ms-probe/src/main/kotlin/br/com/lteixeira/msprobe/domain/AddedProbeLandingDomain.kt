package br.com.lteixeira.msprobe.domain

import br.com.lteixeira.msprobe.application.enumeration.Direction

data class AddedProbeLandingDomain(
    val id: String,
    val probe: String,
    val planet: String,
    val probeLandingCoordinate: AddedProbeLandingCoordinateDomain
)

data class AddedProbeLandingCoordinateDomain(
    val locationX: Int,
    val locationY: Int,
    val direction: Direction
)
