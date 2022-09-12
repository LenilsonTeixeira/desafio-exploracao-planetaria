package br.com.lteixeira.msplanet.api.model

data class GetAllPlanetsResponse(
    val id: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)