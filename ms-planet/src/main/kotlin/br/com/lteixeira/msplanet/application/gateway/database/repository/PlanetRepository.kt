package br.com.lteixeira.msplanet.application.gateway.database.repository

import br.com.lteixeira.msplanet.application.gateway.database.document.PlanetDocumet
import org.springframework.data.mongodb.repository.MongoRepository

interface PlanetRepository : MongoRepository<PlanetDocumet, String> {
    fun findByName(name: String): PlanetDocumet?
    fun findByExternalId(externalId: String): PlanetDocumet?
    fun existsByName(name: String): Boolean
    fun existsByNameAndExternalIdNotLike(name: String, externalId: String): Boolean
}