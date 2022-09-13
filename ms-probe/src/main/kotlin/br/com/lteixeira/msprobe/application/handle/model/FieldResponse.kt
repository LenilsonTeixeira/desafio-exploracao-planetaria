package br.com.lteixeira.msplanet.application.handle.model

data class FieldResponse(
    val field: String,
    val message: String,
    val value: Any? = null
)