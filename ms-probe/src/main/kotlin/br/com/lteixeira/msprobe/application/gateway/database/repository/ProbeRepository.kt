package br.com.lteixeira.msprobe.application.gateway.database.repository

import br.com.lteixeira.msprobe.application.gateway.database.document.ProbeDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ProbeRepository: MongoRepository<ProbeDocument, String> {
    fun findByName(name: String): ProbeDocument?
    fun findByExternalId(externalId: String): ProbeDocument?
    fun existsByName(name: String): Boolean
    fun existsByNameAndExternalIdNotLike(name: String, externalId: String): Boolean
}