package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.domain.SearchProbeCollisionDomain
import org.springframework.stereotype.Component

@Component
class ProcessProbeImpactAnalyzerUseCase(private val getProbeCollisionUseCase: GetProbeCollisionUseCase) {
    fun execute(searchProbeCollisionDomain: SearchProbeCollisionDomain): Boolean {
        val result = getProbeCollisionUseCase.execute(searchProbeCollisionDomain)
        return result.probes.isNotEmpty()
    }
}