package br.com.lteixeira.msplanet.domain

data class UpdatedPlanetDomain(
    val externalId: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
