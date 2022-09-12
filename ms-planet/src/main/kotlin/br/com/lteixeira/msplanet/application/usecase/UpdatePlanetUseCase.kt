package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.exception.UpdatePlanetException
import br.com.lteixeira.msplanet.application.gateway.UpdatePlanetGateway
import br.com.lteixeira.msplanet.domain.UpdatePlanetDomain
import br.com.lteixeira.msplanet.domain.UpdatedPlanetDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class UpdatePlanetUseCase(
    private val updatePlanetGateway: UpdatePlanetGateway,
    private val getPlanetUseCase: GetPlanetUseCase
) {

    companion object {
        private val log = LoggerFactory.getLogger(UpdatePlanetUseCase::class.java)
    }

    fun execute(id: String, updatePlanetDomain: UpdatePlanetDomain): UpdatedPlanetDomain {
        val planet = getPlanetUseCase.execute(id)
        runCatching {
            updatePlanetDomain.id = planet.id
            log.info("Preparando para atualizar planeta com id: $id")
            return updatePlanetGateway.update(updatePlanetDomain)
        }.getOrElse {
            log.error("Falha ao atualizar planeta ${updatePlanetDomain}. Erro: $it")
            throw UpdatePlanetException("Falha ao atualizar planeta com id: $id")
        }
    }
}