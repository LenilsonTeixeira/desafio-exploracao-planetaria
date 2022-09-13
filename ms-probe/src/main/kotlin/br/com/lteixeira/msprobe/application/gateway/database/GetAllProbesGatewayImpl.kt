package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.gateway.GetAllProbesGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeRepository
import br.com.lteixeira.msprobe.application.toGetAllProbesDomain
import br.com.lteixeira.msprobe.domain.GetAllProbesDomain
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class GetAllProbesGatewayImpl(private val probeRepository: ProbeRepository): GetAllProbesGateway {
    override fun getAll(page: Int, size: Int): Page<GetAllProbesDomain> {
        return probeRepository.findAll(PageRequest.of(page, size)).map { it.toGetAllProbesDomain() }
    }
}