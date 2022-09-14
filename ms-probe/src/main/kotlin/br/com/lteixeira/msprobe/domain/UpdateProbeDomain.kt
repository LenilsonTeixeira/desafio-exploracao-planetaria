package br.com.lteixeira.msprobe.domain

data class UpdateProbeDomain(
    var id: Long? = null,
    val externalId: String,
    val name: String
)