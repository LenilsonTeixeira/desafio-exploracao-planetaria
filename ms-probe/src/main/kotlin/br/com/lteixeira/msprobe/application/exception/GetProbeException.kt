package br.com.lteixeira.msprobe.application.exception

import org.springframework.http.HttpStatus

class GetProbeException(message: String): BaseException(message) {
    override fun getStatus() = HttpStatus.NOT_FOUND
}