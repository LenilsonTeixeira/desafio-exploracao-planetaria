package br.com.lteixeira.msplanet.application.validator

interface Validator<T> {
    fun validate(value: T)
}