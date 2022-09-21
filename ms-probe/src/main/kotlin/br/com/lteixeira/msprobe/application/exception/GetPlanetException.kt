package br.com.lteixeira.msprobe.application.exception

import org.springframework.http.HttpStatus

class GetPlanetException(message: String): BaseException(message) {
    override fun getStatus() = HttpStatus.NOT_FOUND
}