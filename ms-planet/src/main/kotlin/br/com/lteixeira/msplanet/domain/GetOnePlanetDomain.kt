package br.com.lteixeira.msplanet.domain

data class GetOnePlanetDomain(
    val id: String,
    val externalId: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
