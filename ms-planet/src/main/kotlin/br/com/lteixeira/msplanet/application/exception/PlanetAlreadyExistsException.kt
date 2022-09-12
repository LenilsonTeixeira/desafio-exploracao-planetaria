package br.com.lteixeira.msplanet.application.exception

import org.springframework.http.HttpStatus

class PlanetAlreadyExistsException(message: String) : BaseException(message) {
    override fun getStatus() = HttpStatus.UNPROCESSABLE_ENTITY
}