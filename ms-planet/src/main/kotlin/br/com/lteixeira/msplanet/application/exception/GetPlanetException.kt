package br.com.lteixeira.msplanet.application.exception

import org.springframework.http.HttpStatus

class GetPlanetException(message: String) : BaseException(message) {
    override fun getStatus()= HttpStatus.NOT_FOUND
}