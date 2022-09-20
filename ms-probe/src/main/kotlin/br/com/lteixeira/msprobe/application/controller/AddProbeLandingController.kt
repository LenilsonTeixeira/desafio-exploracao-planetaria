package br.com.lteixeira.msprobe.application.controller

import br.com.lteixeira.msprobe.api.AddProbeLandingApi
import br.com.lteixeira.msprobe.api.model.AddProbeLandingRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeLandingResponse
import br.com.lteixeira.msprobe.application.converter.toAddProbeLandingDomain
import br.com.lteixeira.msprobe.application.converter.toAddedProbeLandingResponse
import br.com.lteixeira.msprobe.application.usecase.AddProbeLandingUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class AddProbeLandingController(private val addProbeLandingUseCase: AddProbeLandingUseCase): AddProbeLandingApi {
    override fun addLanding(
        @PathVariable("probe")
        probe: String,
        @Valid @RequestBody
        addProbeLandingRequest: AddProbeLandingRequest
    ): AddedProbeLandingResponse {
        val request = addProbeLandingRequest.toAddProbeLandingDomain(probe)
        return addProbeLandingUseCase.execute(request).toAddedProbeLandingResponse()
    }
}