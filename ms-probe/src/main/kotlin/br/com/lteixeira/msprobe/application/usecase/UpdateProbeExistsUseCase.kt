package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.gateway.UpdateProbeExistsGateway
import org.springframework.stereotype.Component

@Component
class UpdateProbeExistsUseCase(private val updateProbeExistsGateway: UpdateProbeExistsGateway) {
    fun execute(name: String, externalId: String): Boolean {
        return updateProbeExistsGateway.existsByNameAndExternalIdNotLike(name,externalId)
    }
}