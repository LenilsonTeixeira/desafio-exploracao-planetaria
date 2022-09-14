package br.com.lteixeira.msprobe.application.gateway.database.repository

import br.com.lteixeira.msprobe.application.gateway.database.entity.ProbeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProbeRepository: JpaRepository<ProbeEntity, Long> {
    fun findByName(name: String): ProbeEntity?
    fun findByExternalId(externalId: String): ProbeEntity?
    fun existsByName(name: String): Boolean
    fun existsByNameAndExternalIdNotLike(name: String, externalId: String): Boolean
}