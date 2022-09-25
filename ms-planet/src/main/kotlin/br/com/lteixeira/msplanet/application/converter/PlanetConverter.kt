package br.com.lteixeira.msplanet.application.converter

import br.com.lteixeira.msplanet.api.model.AddPlanetRequest
import br.com.lteixeira.msplanet.api.model.AddedPlanetResponse
import br.com.lteixeira.msplanet.api.model.GetAllPlanetsResponse
import br.com.lteixeira.msplanet.api.model.GetOnePlanetResponse
import br.com.lteixeira.msplanet.api.model.UpdatePlanetRequest
import br.com.lteixeira.msplanet.api.model.UpdatedPlanetResponse
import br.com.lteixeira.msplanet.application.gateway.database.document.PlanetDocumet
import br.com.lteixeira.msplanet.application.gateway.message.model.Planet
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import br.com.lteixeira.msplanet.domain.AddedPlanetDomain
import br.com.lteixeira.msplanet.domain.GetAllPlanetsDomain
import br.com.lteixeira.msplanet.domain.GetOnePlanetDomain
import br.com.lteixeira.msplanet.domain.GetPlanetDomain
import br.com.lteixeira.msplanet.domain.UpdatePlanetDomain
import br.com.lteixeira.msplanet.domain.UpdatedPlanetDomain
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

fun PlanetDocumet.toGetOnePlanetDomain(): GetOnePlanetDomain {
    return GetOnePlanetDomain(
        id = this.id!!,
        externalId = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun GetOnePlanetDomain.toGetOnePlanetResponse(): GetOnePlanetResponse {
    return GetOnePlanetResponse(
        id = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun PlanetDocumet.toGetPlanetDomain(): GetPlanetDomain {
    return GetPlanetDomain(
        id = this.id!!,
        externalId = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun UpdatePlanetRequest.toUpdatePlanetDomain(id: String): UpdatePlanetDomain {
    return UpdatePlanetDomain(
        externalId = id,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun UpdatePlanetDomain.toPlanetDocument(): PlanetDocumet {
    return PlanetDocumet(
        id = this.id,
        externalId = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun PlanetDocumet.toUpdatedPlanetDomain(): UpdatedPlanetDomain {
    return UpdatedPlanetDomain(
        externalId = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun UpdatedPlanetDomain.toUpdatedPlanetResponse(): UpdatedPlanetResponse {
    return UpdatedPlanetResponse(
        id = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun PlanetDocumet.toGetAllPlanetsDomain(): GetAllPlanetsDomain {
    return GetAllPlanetsDomain(
        id = this.externalId,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun GetAllPlanetsDomain.toGetAllPlanetsResponse(): GetAllPlanetsResponse {
    return GetAllPlanetsResponse(
        id = this.id,
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}

fun AddedPlanetDomain.toPlanet(): Planet {
    return Planet(
        name = this.name,
        cartesianCoordinateSystemArea = this.cartesianCoordinateSystemArea
    )
}