package br.com.lteixeira.msplanet.application.exception

import org.springframework.http.HttpStatus

class AddPlanetException(message: String) : BaseException(message) {
    override fun getStatus() = HttpStatus.INTERNAL_SERVER_ERROR
}