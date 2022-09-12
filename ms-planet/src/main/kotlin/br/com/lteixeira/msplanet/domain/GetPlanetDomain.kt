package br.com.lteixeira.msplanet.domain

data class GetPlanetDomain(
    val id: String,
    val externalId: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
