package br.com.lteixeira.msprobe.api.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class AddProbeLandingRequest(
    @field:NotBlank val planet: String,
    val probeLandingCoordinate: AddProbeLandingCoordinateRequest
)

data class AddProbeLandingCoordinateRequest(
    @field:Min(2) val locationX: Int,
    @field:Min(2) val locationY: Int,
)
