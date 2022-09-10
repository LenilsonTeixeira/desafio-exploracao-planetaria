package br.com.lteixeira.msplanet.application.gateway.database.document

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "planet")
data class PlanetDocumet(
    @Id
    val id: String,
    val externalId: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int,
    @CreatedDate
    val createdDate: LocalDateTime,
    @LastModifiedDate
    val lastModifiedDate: LocalDateTime
)
