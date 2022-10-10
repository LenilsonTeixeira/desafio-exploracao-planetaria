package br.com.lteixeira.msimpactanalyzer.builder

import br.com.lteixeira.msimpactanalyzer.model.SearchRequestParam
import org.elasticsearch.index.query.BoolQueryBuilder
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders

class QueryRequestBuilder {
    companion object {
        fun build(searchRequestParam: SearchRequestParam): QueryBuilder {
            val first: BoolQueryBuilder = QueryBuilders.boolQuery()
            val second: BoolQueryBuilder = QueryBuilders.boolQuery()

            first.must(QueryBuilders.matchQuery("planet", searchRequestParam.planet))
                .must(QueryBuilders.matchQuery("probe", searchRequestParam.probe))

            second.should(QueryBuilders.matchQuery("locationX", searchRequestParam.locationX))
                .should( QueryBuilders.matchQuery("locationY", searchRequestParam.locationY))

            val query: BoolQueryBuilder = BoolQueryBuilder()
            query.must(first).must(second)

            return query

        }
    }
}