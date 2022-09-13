package br.com.lteixeira.msprobe.application.gateway.database.repository

import br.com.lteixeira.msprobe.application.gateway.database.document.ProbeDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ProbeRepository: MongoRepository<ProbeDocument, String> {
    fun existsByName(name: String): Boolean
}