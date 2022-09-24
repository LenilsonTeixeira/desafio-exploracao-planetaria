package br.com.lteixeira.msprobe.application.gateway.database.repository

import br.com.lteixeira.msprobe.application.gateway.database.entity.ProbeCommandEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProbeCommandRepository: JpaRepository<ProbeCommandEntity, Long> {
}