package br.com.lteixeira.msprobe.application.converter

import br.com.lteixeira.msprobe.api.model.AddProbeLandingRequest
import br.com.lteixeira.msprobe.api.model.AddProbeRequest
import br.com.lteixeira.msprobe.api.model.AddedProbeLandingCoordinateResponse
import br.com.lteixeira.msprobe.api.model.AddedProbeLandingResponse
import br.com.lteixeira.msprobe.api.model.AddedProbeResponse
import br.com.lteixeira.msprobe.api.model.GetAllProbesResponse
import br.com.lteixeira.msprobe.api.model.GetOneProbeResponse
import br.com.lteixeira.msprobe.api.model.UpdateProbeRequest
import br.com.lteixeira.msprobe.api.model.UpdatedProbeResponse
import br.com.lteixeira.msprobe.application.enumeration.Direction
import br.com.lteixeira.msprobe.application.gateway.database.entity.ProbeEntity
import br.com.lteixeira.msprobe.application.gateway.database.entity.ProbeLandingEntity
import br.com.lteixeira.msprobe.domain.AddProbeDomain
import br.com.lteixeira.msprobe.domain.AddProbeLandingCoordinateDomain
import br.com.lteixeira.msprobe.domain.AddProbeLandingDomain
import br.com.lteixeira.msprobe.domain.AddedProbeDomain
import br.com.lteixeira.msprobe.domain.AddedProbeLandingCoordinateDomain
import br.com.lteixeira.msprobe.domain.AddedProbeLandingDomain
import br.com.lteixeira.msprobe.domain.GetAllProbesDomain
import br.com.lteixeira.msprobe.domain.GetOneProbeDomain
import br.com.lteixeira.msprobe.domain.GetProbeDomain
import br.com.lteixeira.msprobe.domain.UpdateProbeDomain
import br.com.lteixeira.msprobe.domain.UpdatedProbeDomain
import java.time.LocalDateTime
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

fun AddProbeDomain.toProbeEntity(): ProbeEntity {
    return ProbeEntity(
        name = this.name,
        externalId = UUID.randomUUID().toString()
    )
}

fun ProbeEntity.toAddedProbeDomain(): AddedProbeDomain {
    return AddedProbeDomain(
        id = this.externalId,
        name = this.name
    )
}

fun ProbeEntity.toGetProbeDomain(): GetProbeDomain {
    return GetProbeDomain(
        id = this.id!!,
        externalId = this.externalId,
        name = this.name,
    )
}

fun ProbeEntity.toGetOneProbeDomain(): GetOneProbeDomain {
    return GetOneProbeDomain(
        id = this.id!!,
        externalId = this.externalId,
        name = this.name
    )
}

fun GetOneProbeDomain.toGetOneProbeResponse(): GetOneProbeResponse {
    return GetOneProbeResponse(
        id = this.externalId,
        name = this.name
    )
}

fun ProbeEntity.toGetAllProbesDomain(): GetAllProbesDomain {
    return GetAllProbesDomain(
        id = this.externalId,
        name = this.name
    )
}

fun GetAllProbesDomain.toGetAllProbesResponse(): GetAllProbesResponse {
    return GetAllProbesResponse(
        id = this.id,
        name = this.name
    )
}

fun UpdateProbeRequest.toUpdateProbeDomain(id: String): UpdateProbeDomain {
    return UpdateProbeDomain(
        externalId = id,
        name = name
    )
}

fun UpdatedProbeDomain.toUpdatedProbeResponse(): UpdatedProbeResponse {
    return UpdatedProbeResponse(
        id = this.externalId,
        name = this.name
    )
}

fun UpdateProbeDomain.toProbeEntity(): ProbeEntity {
    return ProbeEntity(
        id = this.id,
        externalId = this.externalId,
        name = this.name
    )
}

fun ProbeEntity.toUpdatedProbeDomain(): UpdatedProbeDomain {
    return UpdatedProbeDomain(
        externalId = this.externalId,
        name = this.name,
    )
}

fun AddProbeLandingRequest.toAddProbeLandingDomain(probeName: String): AddProbeLandingDomain {
    return AddProbeLandingDomain(
        planet = this.planet,
        probeName = probeName,
        probeLandingCoordinate = AddProbeLandingCoordinateDomain(
            locationX = this.probeLandingCoordinate.locationX,
            locationY = this.probeLandingCoordinate.locationY,
            direction = Direction.valueOf(this.probeLandingCoordinate.direction)
        )
    )
}

fun AddProbeLandingDomain.toProbeLandingEntity(): ProbeLandingEntity {
    return ProbeLandingEntity(
        probe = ProbeEntity(
            id = this.probeEntityDomain?.id,
            externalId = this.probeEntityDomain!!.externalId,
            name = this.probeEntityDomain!!.name),
        externalId = UUID.randomUUID().toString(),
        planet = this.planet,
        locationY = this.probeLandingCoordinate.locationY,
        locationX = this.probeLandingCoordinate.locationX,
        direction = this.probeLandingCoordinate.direction,
        createdDate = LocalDateTime.now(),
        lastModifiedDate = LocalDateTime.now()
    )
}

fun ProbeLandingEntity.toAddedProbeLandingDomain(): AddedProbeLandingDomain {
    return AddedProbeLandingDomain(
        id = this.externalId,
        planet = this.planet,
        probe = this.probe.name,
        probeLandingCoordinate = AddedProbeLandingCoordinateDomain(
            locationX = this.locationX,
            locationY = this.locationY,
            direction = this.direction,
        )
    )
}

fun AddedProbeLandingDomain.toAddedProbeLandingResponse(): AddedProbeLandingResponse {
    return AddedProbeLandingResponse(
        id = this.id,
        planet = this.planet,
        probe = this.probe,
        probeLandingCoordinate = AddedProbeLandingCoordinateResponse(
            locationX = this.probeLandingCoordinate.locationX,
            locationY = this.probeLandingCoordinate.locationY,
            direction = this.probeLandingCoordinate.direction.name
        )
    )
}