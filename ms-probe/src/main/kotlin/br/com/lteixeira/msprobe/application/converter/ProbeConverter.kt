package br.com.lteixeira.msprobe.application

import br.com.lteixeira.msprobe.api.model.AddProbeRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeResponse
import br.com.lteixeira.msprobe.application.gateway.database.document.ProbeDocument
import br.com.lteixeira.msprobe.domain.AddProbeDomain
import br.com.lteixeira.msprobe.domain.AddedProbeDomain
import java.util.UUID

fun AddProbeRequest.toAddProbeDomain(): AddProbeDomain {
    return AddProbeDomain(
        name = this.name
    )
}

fun AddedProbeDomain.toAddedProbeResponse(): AddedProbeResponse {
    return AddedProbeResponse(
        id = this.id,
        name = this.name
    )
}

fun AddProbeDomain.toProbeDocument(): ProbeDocument {
    return ProbeDocument(
        name = this.name,
        externalId = UUID.randomUUID().toString()
    )
}

fun ProbeDocument.toAddedProbeDomain(): AddedProbeDomain {
    return AddedProbeDomain(
        id = this.externalId,
        name = this.name
    )
}