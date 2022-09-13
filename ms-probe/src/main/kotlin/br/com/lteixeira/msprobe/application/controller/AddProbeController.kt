package br.com.lteixeira.msprobe.application.controller

import br.com.lteixeira.msprobe.api.AddProbeApi
import br.com.lteixeira.msprobe.api.model.AddProbeRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeResponse
import br.com.lteixeira.msprobe.application.toAddProbeDomain
import br.com.lteixeira.msprobe.application.toAddedProbeResponse
import br.com.lteixeira.msprobe.application.usecase.AddProbeUseCase
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class AddProbeController(private val addProbeUseCase: AddProbeUseCase) : AddProbeApi {
    override fun add(@Valid @RequestBody addProbeRequest: AddProbeRequest): AddedProbeResponse {
        val request = addProbeRequest.toAddProbeDomain()
        return addProbeUseCase.execute(request).toAddedProbeResponse()
    }
}