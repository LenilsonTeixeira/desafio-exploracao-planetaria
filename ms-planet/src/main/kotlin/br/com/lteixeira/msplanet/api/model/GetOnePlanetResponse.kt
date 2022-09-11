package br.com.lteixeira.msplanet.api.model

data class GetOnePlanetResponse(
    val id: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
