package br.com.lteixeira.msplanet.application.exception

import org.springframework.http.HttpStatus

class UpdatePlanetException(message: String) : BaseException(message) {
    override fun getStatus() = HttpStatus.INTERNAL_SERVER_ERROR
}