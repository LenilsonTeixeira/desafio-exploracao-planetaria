package br.com.lteixeira.msimpactanalyzer.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

data class SearchRequestParam(
    @JsonProperty("planet")
    @field:NotBlank val planet: String,
    @JsonProperty("probe")
    @field:NotBlank val probe: String,
    @JsonProperty("locationY")
    val locationY: Int,
    @JsonProperty("locationX")
    val locationX: Int,
)
