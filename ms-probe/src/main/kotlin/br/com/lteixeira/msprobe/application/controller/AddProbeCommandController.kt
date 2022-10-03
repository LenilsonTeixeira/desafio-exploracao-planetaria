package br.com.lteixeira.msprobe.application.controller

import br.com.lteixeira.msprobe.api.AddProbeCommandApi
import br.com.lteixeira.msprobe.api.model.AddProbeCommandRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeCommandResponse
import br.com.lteixeira.msprobe.application.converter.toAddProbeCommandDomain
import br.com.lteixeira.msprobe.application.converter.toAddedProbeCommandResponse
import br.com.lteixeira.msprobe.application.usecase.AddProbeCommandUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class AddProbeCommandController(private val addProbeCommandUseCase: AddProbeCommandUseCase) : AddProbeCommandApi {
    override fun addCommand(
        @PathVariable("probe") probe: String,
        @PathVariable("planet") planet: String,
        @Valid @RequestBody addProbeCommandRequest: AddProbeCommandRequest
    ): AddedProbeCommandResponse {
        val request = addProbeCommandRequest.toAddProbeCommandDomain(probe, planet)
        return addProbeCommandUseCase.execute(request).toAddedProbeCommandResponse()
    }
}