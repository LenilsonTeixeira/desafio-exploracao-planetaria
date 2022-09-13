package br.com.lteixeira.msprobe.domain

data class UpdateProbeDomain(
    var id: String? = "",
    val externalId: String,
    val name: String
)