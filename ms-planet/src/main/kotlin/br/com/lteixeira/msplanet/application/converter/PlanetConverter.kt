package br.com.lteixeira.msplanet.application.gateway

import br.com.lteixeira.msplanet.api.model.AddPlanetRequest
import br.com.lteixeira.msplanet.api.model.AddedPlanetResponse
import br.com.lteixeira.msplanet.application.gateway.database.document.PlanetDocumet
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import br.com.lteixeira.msplanet.domain.AddedPlanetDomain
import java.util.UUID

fun AddPlanetRequest.toAddPlanetDomain(): AddPlanetDomain {
    return AddPlanetDomain(
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun AddedPlanetDomain.toAddedPlanetResponse(): AddedPlanetResponse {
    return AddedPlanetResponse(
        id = this.id,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun AddPlanetDomain.toPlanetDocument(): PlanetDocumet {
    return PlanetDocumet(
        externalId = UUID.randomUUID().toString(),
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea,
    )
}

fun PlanetDocumet.toAddedPlanetDomain(): AddedPlanetDomain {
    return AddedPlanetDomain(
        id = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}