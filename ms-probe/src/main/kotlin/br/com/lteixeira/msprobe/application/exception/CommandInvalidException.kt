package br.com.lteixeira.msprobe.application.exception

import org.springframework.http.HttpStatus

class CommandInvalidException(message: String): BaseException(message) {
    override fun getStatus() = HttpStatus.BAD_REQUEST
}