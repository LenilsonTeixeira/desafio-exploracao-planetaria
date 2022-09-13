package br.com.lteixeira.msprobe.application.validator

interface Validator<T> {
    fun validate(value: T)
}