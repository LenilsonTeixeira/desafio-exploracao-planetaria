package br.com.lteixeira.msprobe.api.model

data class AddedProbeCommandResponse(
    val command: String,
    val direction: String,
    val probeCommandCoordinate: AddProbeCommandCoordinateResponse
)

data class AddProbeCommandCoordinateResponse(
    val locationX: Int,
    val locationY: Int,
)