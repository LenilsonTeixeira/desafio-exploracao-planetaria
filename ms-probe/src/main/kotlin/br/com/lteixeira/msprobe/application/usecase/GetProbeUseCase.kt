package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.exception.GetProbeException
import br.com.lteixeira.msprobe.application.gateway.GetProbeGateway
import br.com.lteixeira.msprobe.domain.GetProbeDomain
import org.springframework.stereotype.Component

@Component
class GetProbeUseCase(private val getProbeGateway: GetProbeGateway) {
    fun execute(externalId: String): GetProbeDomain {
        return getProbeGateway.getByExternalId(externalId)
            ?: throw GetProbeException("Sonda com id: $externalId não encontrada")
    }
}