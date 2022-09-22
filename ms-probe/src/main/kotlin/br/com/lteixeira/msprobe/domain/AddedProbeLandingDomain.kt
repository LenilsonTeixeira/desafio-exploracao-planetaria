package br.com.lteixeira.msprobe.domain

data class AddedProbeLandingDomain(
    val id: String,
    val probe: String,
    val planet: String,
    val probeLandingCoordinate: AddedProbeLandingCoordinateDomain
)

data class AddedProbeLandingCoordinateDomain(
    val locationX: Int,
    val locationY: Int,
)
