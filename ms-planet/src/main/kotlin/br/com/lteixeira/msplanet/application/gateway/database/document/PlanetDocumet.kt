package br.com.lteixeira.msplanet.application.gateway.database.document

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "planet")
data class PlanetDocumet(
    @Id
    val id: String? = null,
    val externalId: String,
    val name: String,
    val cartesianCoordinateSystemArea: Int,
    @CreatedDate
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val lastModifiedDate: LocalDateTime = LocalDateTime.now()
)
