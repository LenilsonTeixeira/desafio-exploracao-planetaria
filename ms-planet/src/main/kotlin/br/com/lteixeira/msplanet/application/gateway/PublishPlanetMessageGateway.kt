package br.com.lteixeira.msplanet.application.gateway

import br.com.lteixeira.msplanet.application.gateway.message.model.Planet

interface PublishPlanetMessageGateway {
    fun publish(planet: Planet)
}