package br.com.lteixeira.msplanet.domain

data class GetAllPlanetsDomain(
    val id: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
