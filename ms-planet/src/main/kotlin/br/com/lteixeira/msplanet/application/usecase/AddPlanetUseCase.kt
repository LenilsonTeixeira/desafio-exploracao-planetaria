package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.exception.AddPlanetException
import br.com.lteixeira.msplanet.application.gateway.AddPlanetGateway
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import br.com.lteixeira.msplanet.domain.AddedPlanetDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AddPlanetUseCase(val addPlanetGateway: AddPlanetGateway) {

    companion object {
        private val log = LoggerFactory.getLogger(AddPlanetUseCase::class.java)
    }

    fun execute(addPlanetDomain: AddPlanetDomain): AddedPlanetDomain {
        runCatching {
            log.info("Cadastrando planeta: ${addPlanetDomain.name}")
            return addPlanetGateway.add(addPlanetDomain)
        }.getOrElse {
            log.error("Falha ao salvar planeta: ${addPlanetDomain.name}. Erro: $it")
            throw AddPlanetException("Ocorreu um erro ao salvar planeta: ${addPlanetDomain.name}")
        }
    }
}