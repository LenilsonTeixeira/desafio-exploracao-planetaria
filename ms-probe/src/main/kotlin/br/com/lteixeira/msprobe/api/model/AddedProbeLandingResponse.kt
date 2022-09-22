package br.com.lteixeira.msprobe.api.model

data class AddedProbeLandingResponse(
    val id: String,
    val planet: String,
    val probe: String,
    val probeLandingCoordinate: AddedProbeLandingCoordinateResponse
)

data class AddedProbeLandingCoordinateResponse(
    val locationX: Int,
    val locationY: Int,
)