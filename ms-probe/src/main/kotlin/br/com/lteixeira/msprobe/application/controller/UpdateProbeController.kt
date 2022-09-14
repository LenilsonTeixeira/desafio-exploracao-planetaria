package br.com.lteixeira.msprobe.application.controller

import br.com.lteixeira.msprobe.api.UpdateProbeApi
import br.com.lteixeira.msprobe.api.model.UpdateProbeRequest
import br.com.lteixeira.msprobe.api.model.UpdatedProbeResponse
import br.com.lteixeira.msprobe.application.converter.toUpdateProbeDomain
import br.com.lteixeira.msprobe.application.converter.toUpdatedProbeResponse
import br.com.lteixeira.msprobe.application.usecase.UpdateProbeUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UpdateProbeController(private val updateProbeUseCase: UpdateProbeUseCase) : UpdateProbeApi {
    override fun update(
        @PathVariable("id") id: String,
        @Valid @RequestBody updateProbeRequest: UpdateProbeRequest
    ): UpdatedProbeResponse {
        val probe = updateProbeRequest.toUpdateProbeDomain(id)
        return updateProbeUseCase.execute(id, probe).toUpdatedProbeResponse()
    }
}