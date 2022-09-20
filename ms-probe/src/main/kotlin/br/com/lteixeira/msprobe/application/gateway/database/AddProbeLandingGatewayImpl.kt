package br.com.lteixeira.msprobe.application.gateway.database

import br.com.lteixeira.msprobe.application.converter.toAddedProbeLandingDomain
import br.com.lteixeira.msprobe.application.converter.toProbeLandingEntity
import br.com.lteixeira.msprobe.application.gateway.AddProbeLandingGateway
import br.com.lteixeira.msprobe.application.gateway.database.repository.ProbeLandingRepository
import br.com.lteixeira.msprobe.domain.AddProbeLandingDomain
import br.com.lteixeira.msprobe.domain.AddedProbeLandingDomain
import org.springframework.stereotype.Service

@Service
class AddProbeLandingGatewayImpl(private val probeLandingRepository: ProbeLandingRepository) : AddProbeLandingGateway {
    override fun addLanding(addProbeLandingDomain: AddProbeLandingDomain): AddedProbeLandingDomain {
        val probeLanding = addProbeLandingDomain.toProbeLandingEntity()
        return probeLandingRepository.save(probeLanding).toAddedProbeLandingDomain()
    }
}