package br.com.lteixeira.msplanet.application.usecase

import br.com.lteixeira.msplanet.application.exception.AddPlanetException
import br.com.lteixeira.msplanet.application.gateway.AddPlanetGateway
import br.com.lteixeira.msplanet.application.validator.AddPlanetValidator
import br.com.lteixeira.msplanet.domain.AddPlanetDomain
import br.com.lteixeira.msplanet.domain.AddedPlanetDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AddPlanetUseCase(
    private val addPlanetValidator: AddPlanetValidator,
    private val addPlanetGateway: AddPlanetGateway
) {
    companion object {
        private val log = LoggerFactory.getLogger(AddPlanetUseCase::class.java)
    }

    fun execute(addPlanetDomain: AddPlanetDomain): AddedPlanetDomain {
        log.info("Executando regras de validação para cadastro de planeta");
        addPlanetValidator.validate(addPlanetDomain)

        runCatching {
            log.info("Preparando para cadastrar planeta: ${addPlanetDomain.name}")
            return addPlanetGateway.add(addPlanetDomain)
        }.getOrElse {
            log.error("Falha ao salvar planeta: ${addPlanetDomain.name}. Erro: $it")
            throw AddPlanetException("Ocorreu um erro ao salvar planeta: ${addPlanetDomain.name}")
        }
    }
}