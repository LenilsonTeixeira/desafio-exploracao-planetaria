package br.com.lteixeira.msprobe.application.controller

import br.com.lteixeira.msprobe.api.GetOneProbeApi
import br.com.lteixeira.msprobe.api.model.GetOneProbeResponse
import br.com.lteixeira.msprobe.application.converter.toGetOneProbeResponse
import br.com.lteixeira.msprobe.application.usecase.GetOneProbeUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetOneProbeController(private val getOneProbeUseCase: GetOneProbeUseCase): GetOneProbeApi{
    override fun getOne(@PathVariable("name") name: String): GetOneProbeResponse {
        return getOneProbeUseCase.execute(name).toGetOneProbeResponse()
    }
}