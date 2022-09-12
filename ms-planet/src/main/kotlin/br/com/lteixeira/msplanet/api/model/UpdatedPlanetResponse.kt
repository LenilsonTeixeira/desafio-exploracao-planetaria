package br.com.lteixeira.msplanet.api.model

data class UpdatedPlanetResponse(
    val id: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
