package br.com.lteixeira.msimpactanalyzer.service

import br.com.lteixeira.msimpactanalyzer.document.Probe
import br.com.lteixeira.msimpactanalyzer.exception.SearchResultException
import br.com.lteixeira.msimpactanalyzer.mapper.SearchHitToProbeMapper
import br.com.lteixeira.msimpactanalyzer.model.ProbeData
import br.com.lteixeira.msimpactanalyzer.repository.ProbeCollisionRepository
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.search.SearchResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class ProbeCollisionService(private val probeCollisionRepository: ProbeCollisionRepository) {

    companion object {
        private val log = LoggerFactory.getLogger(ProbeCollisionService::class.java)
    }

    fun search(request: SearchRequest): ProbeData {
        runCatching {
            log.info("Verificando sondas em rota de colisão.")
            val response = probeCollisionRepository.searchBy(request)
            val probes: List<Probe> = getProbes(response)
            return buildResponseData(response, probes)
        }.getOrElse {
            log.error("Ocorreu uma falha ao executar consulta de rota de colisão. Erro: $it")
            throw SearchResultException("Falha ao executar consulta de rota de colisão.")
        }
    }

    private fun getTotalElements(searchResponse: SearchResponse): Long {
        return searchResponse.hits.totalHits?.value ?: 0
    }

    private fun buildResponseData(response: SearchResponse, probes: List<Probe>): ProbeData {
        return ProbeData(totalElements = getTotalElements(response), probes = probes)
    }

    private fun getProbes(response: SearchResponse): List<Probe> {
        return Arrays.stream(response.hits.hits)
            .map { SearchHitToProbeMapper.mapper(it) }
            .toList()
    }
}