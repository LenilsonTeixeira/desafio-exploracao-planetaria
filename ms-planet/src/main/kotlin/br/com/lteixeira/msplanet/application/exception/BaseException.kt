package br.com.lteixeira.msplanet.application.exception

import org.springframework.http.HttpStatus

abstract class BaseException(override val message: String): RuntimeException() {

    abstract fun getStatus(): HttpStatus
}