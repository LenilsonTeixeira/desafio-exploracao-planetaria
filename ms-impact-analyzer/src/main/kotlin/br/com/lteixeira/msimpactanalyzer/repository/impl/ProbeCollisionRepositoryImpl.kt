package br.com.lteixeira.msimpactanalyzer.repository.impl

import br.com.lteixeira.msimpactanalyzer.repository.ProbeCollisionRepository
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.stereotype.Repository

@Repository
class ProbeCollisionRepositoryImpl(private val restHighLevelClient: RestHighLevelClient ): ProbeCollisionRepository {
    override fun searchBy(searchRequest: SearchRequest): SearchResponse {
        return restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT)
    }
}