package br.com.lteixeira.msprobe.application.gateway

import br.com.lteixeira.msprobe.domain.GetAllProbesDomain
import org.springframework.data.domain.Page

interface GetAllProbesGateway {
    fun getAll(page: Int, size: Int): Page<GetAllProbesDomain>
}