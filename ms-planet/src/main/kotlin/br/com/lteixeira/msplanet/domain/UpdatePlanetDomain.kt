package br.com.lteixeira.msplanet.domain

data class UpdatePlanetDomain(
    var id: String? = "",
    val externalId: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int
)
