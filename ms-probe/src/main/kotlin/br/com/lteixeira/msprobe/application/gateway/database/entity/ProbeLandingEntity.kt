package br.com.lteixeira.msprobe.application.gateway.database.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "probe_landing")
data class ProbeLandingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true, name = "external_id")
    val externalId: String,
    @Column(nullable = false, length = 100, name = "planet")
    val planet: String,
    @Column(nullable = false, name = "location_x")
    val locationX: Int,
    @Column(nullable = false, name = "location_y")
    val locationY: Int,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "probe_id")
    val probe: ProbeEntity,
    @CreatedDate
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val lastModifiedDate: LocalDateTime = LocalDateTime.now()
)