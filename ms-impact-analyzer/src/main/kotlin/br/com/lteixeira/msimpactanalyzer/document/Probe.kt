package br.com.lteixeira.msimpactanalyzer.document

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Probe(
    @JsonProperty("planet")
    val planet: String,
    @JsonProperty("probe")
    val probe: String,
    @JsonProperty("locationY")
    val locationY: Int,
    @JsonProperty("locationX")
    val locationX: Int,
    @JsonProperty("status")
    val status: String
)
