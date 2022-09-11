package br.com.lteixeira.msplanet.application.handle.model

import com.fasterxml.jackson.annotation.JsonInclude

data class ErrorResponse(
    val message: String,
    val status: Int,
    val error: String,
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val fields: MutableSet<FieldResponse>? = null,
    val path: String,
    val timestamp: Long
) {
    fun addField(field: FieldResponse) {
        fields?.add(field)
    }
}
