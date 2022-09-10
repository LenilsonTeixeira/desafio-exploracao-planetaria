package br.com.lteixeira.msplanet.api.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class AddPlanetRequest(
    @field:NotBlank val name: String,
    @field:Min(2) val cartesianCoordinateSystemArea: Int
)
