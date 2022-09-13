package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.exception.GetProbeException
import br.com.lteixeira.msprobe.application.gateway.GetOneProbeGateway
import br.com.lteixeira.msprobe.domain.GetOneProbeDomain
import org.springframework.stereotype.Component

@Component
class GetOneProbeUseCase(private val getOneProbeGateway: GetOneProbeGateway) {
    fun execute(name: String): GetOneProbeDomain {
        return getOneProbeGateway.getOne(name) ?: throw GetProbeException("Sonda: $name não encontrada")
    }
}