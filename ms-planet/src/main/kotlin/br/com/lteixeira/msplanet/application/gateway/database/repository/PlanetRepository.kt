package br.com.lteixeira.msplanet.application.gateway.database.repository

import br.com.lteixeira.msplanet.application.gateway.database.document.PlanetDocumet
import org.springframework.data.mongodb.repository.MongoRepository

interface PlanetRepository : MongoRepository<PlanetDocumet, String> {

}