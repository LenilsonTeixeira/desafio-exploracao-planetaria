package br.com.lteixeira.msprobe.application.exception

import org.springframework.http.HttpStatus

class PublishMessageException(message: String) : BaseException(message) {
    override fun getStatus() = HttpStatus.INTERNAL_SERVER_ERROR
}