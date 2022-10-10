package br.com.lteixeira.msimpactanalyzer.builder

import br.com.lteixeira.msimpactanalyzer.model.SearchRequestParam
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.support.IndicesOptions
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.springframework.beans.factory.annotation.Value

class QueryBuilder {

    @Value("\${elasticsearch.index}")
    private val index: String = "probe-sensor"

    fun build(searchRequestParam: SearchRequestParam): SearchRequest {
        val matchQueryBuilder = QueryRequestBuilder.build(searchRequestParam)
        val searchSourceBuilder: SearchSourceBuilder = buildSearchSourceBuilder(matchQueryBuilder)
        return buildSearchRequest(searchSourceBuilder)
    }

    private fun buildSearchSourceBuilder(matchQueryBuilder: QueryBuilder): SearchSourceBuilder {
        val searchSourceBuilder = SearchSourceBuilder()
        searchSourceBuilder.query(matchQueryBuilder)
        return searchSourceBuilder
    }

    private fun buildSearchRequest(searchSourceBuilder: SearchSourceBuilder): SearchRequest {
        val searchRequest = SearchRequest()
        searchRequest.indices(index).indicesOptions(IndicesOptions.STRICT_EXPAND_OPEN)
        searchRequest.source(searchSourceBuilder)
        return searchRequest
    }
}