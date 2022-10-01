package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.application.gateway.message.model.Probe

interface PublishProbeMessageGateway {
    fun publish(probe: Probe)
}