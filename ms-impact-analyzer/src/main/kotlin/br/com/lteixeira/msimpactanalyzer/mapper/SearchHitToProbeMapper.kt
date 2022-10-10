package br.com.lteixeira.msimpactanalyzer.mapper

import br.com.lteixeira.msimpactanalyzer.document.Probe
import com.fasterxml.jackson.databind.ObjectMapper
import org.elasticsearch.search.SearchHit
import org.springframework.stereotype.Component

@Component
class SearchHitToProbeMapper {
    companion object {
        fun mapper(documentFields: SearchHit): Probe {
            return ObjectMapper().convertValue(documentFields.sourceAsMap, Probe::class.java)
        }
    }
}