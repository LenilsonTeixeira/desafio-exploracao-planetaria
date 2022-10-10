package br.com.lteixeira.msimpactanalyzer.repository
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;

interface ProbeCollisionRepository {
    fun searchBy(searchRequest: SearchRequest): SearchResponse
}