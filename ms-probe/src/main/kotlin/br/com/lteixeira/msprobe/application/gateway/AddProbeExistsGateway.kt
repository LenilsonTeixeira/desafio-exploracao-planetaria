package br.com.lteixeira.msprobe.application.gateway

interface AddProbeExistsGateway {
    fun existsByName(name: String): Boolean
}