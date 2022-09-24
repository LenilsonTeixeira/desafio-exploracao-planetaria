package br.com.lteixeira.msprobe.api.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class AddProbeCommandRequest(
    @field:NotBlank val command: String,
    @field:NotBlank val direction: String,
    val probeCommandCoordinate: AddProbeCommandCoordinateRequest
)

data class AddProbeCommandCoordinateRequest(
    @field:Min(2) val locationX: Int,
    @field:Min(2) val locationY: Int,
)
