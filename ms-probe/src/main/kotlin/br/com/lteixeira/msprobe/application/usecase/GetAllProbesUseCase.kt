package br.com.lteixeira.msprobe.application.usecase

import br.com.lteixeira.msprobe.application.gateway.GetAllProbesGateway
import br.com.lteixeira.msprobe.domain.GetAllProbesDomain
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class GetAllProbesUseCase(private val getAllProbesGateway: GetAllProbesGateway) {
    fun execute(page: Int, size: Int): Page<GetAllProbesDomain> {
        return getAllProbesGateway.getAll(page, size)
    }
}