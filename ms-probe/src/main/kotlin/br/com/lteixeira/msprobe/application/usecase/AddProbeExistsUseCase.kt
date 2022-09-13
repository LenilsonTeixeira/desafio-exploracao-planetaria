package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.gateway.AddProbeExistsGateway
import org.springframework.stereotype.Component

@Component
class AddProbeExistsUseCase(private val addProbeExistsGateway: AddProbeExistsGateway) {
    fun execute(name: String): Boolean {
        return addProbeExistsGateway.existsByName(name)
    }
}