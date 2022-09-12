package br.com.lteixeira.msplanet.application.gateway

interface AddPlanetExistsGateway {
    fun existsByName(name: String): Boolean
}