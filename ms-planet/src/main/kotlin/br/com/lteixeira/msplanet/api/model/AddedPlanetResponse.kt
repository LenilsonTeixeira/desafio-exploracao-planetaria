package br.com.lteixeira.msplanet.api.model

data class AddedPlanetResponse(
    val id: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
