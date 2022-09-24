package br.com.lteixeira.msprobe.application.gateway.database.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "probe")
data class ProbeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true, name = "external_id")
    val externalId: String,
    @Column(nullable = false, unique = true, length = 100, name = "name")
    val name: String,
    @Column(nullable = false, name = "created_date")
    @CreatedDate
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false, name = "last_modified_date")
    @LastModifiedDate
    val lastModifiedDate: LocalDateTime = LocalDateTime.now()
)
