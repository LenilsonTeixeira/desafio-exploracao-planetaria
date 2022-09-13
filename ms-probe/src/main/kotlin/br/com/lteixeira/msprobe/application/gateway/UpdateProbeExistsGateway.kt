package br.com.lteixeira.msprobe.application.gateway

interface UpdateProbeExistsGateway {
    fun existsByNameAndExternalIdNotLike(name: String, externalId: String): Boolean
}