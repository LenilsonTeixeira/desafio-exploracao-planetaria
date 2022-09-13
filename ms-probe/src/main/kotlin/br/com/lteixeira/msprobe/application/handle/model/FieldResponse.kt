package br.com.lteixeira.msprobe.application.handle.model

data class FieldResponse(
    val field: String,
    val message: String,
    val value: Any? = null
)