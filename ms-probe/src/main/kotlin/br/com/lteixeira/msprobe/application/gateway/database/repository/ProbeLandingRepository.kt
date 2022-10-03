package br.com.lteixeira.msprobe.application.gateway.database.repository

import br.com.lteixeira.msprobe.application.gateway.database.entity.ProbeLandingEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProbeLandingRepository: JpaRepository<ProbeLandingEntity, Long> {
    fun findByExternalId(externalId: String): ProbeLandingEntity?
}