package br.com.lteixeira.msprobe.domain

data class AddProbeLandingDomain(
    val probeName: String,
    var probeEntityDomain: GetOneProbeDomain? = null,
    val planet: String,
    val probeLandingCoordinate: AddProbeLandingCoordinateDomain
)

data class AddProbeLandingCoordinateDomain(
    val locationX: Int,
    val locationY: Int,
)