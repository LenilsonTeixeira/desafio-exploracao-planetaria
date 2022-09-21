package br.com.lteixeira.msprobe.application.exception

import org.springframework.http.HttpStatus

class ProbeLandingCartesianCoordinateAreaInvalidException(message: String) : BaseException(message) {
    override fun getStatus() = HttpStatus.UNPROCESSABLE_ENTITY
}