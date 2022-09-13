package br.com.lteixeira.msprobe.application.exception

import org.springframework.http.HttpStatus

abstract class BaseException(override val message: String): RuntimeException() {
    abstract fun getStatus(): HttpStatus
}