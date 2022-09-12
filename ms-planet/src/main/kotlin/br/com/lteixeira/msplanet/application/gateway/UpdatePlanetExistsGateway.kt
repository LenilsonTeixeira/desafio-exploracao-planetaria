package br.com.lteixeira.msplanet.application.gateway

interface UpdatePlanetExistsGateway {
    fun existsByNameAndExternalIdNotLike(name: String, externalId: String): Boolean
}