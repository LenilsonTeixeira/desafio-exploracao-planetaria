package br.com.lteixeira.msprobe.domain

import javax.validation.constraints.NotBlank

data class SearchProbeCollisionDomain(
    @field:NotBlank val planet: String,
    @field:NotBlank val probe: String,
    val locationY: Int,
    val locationX: Int,
)
