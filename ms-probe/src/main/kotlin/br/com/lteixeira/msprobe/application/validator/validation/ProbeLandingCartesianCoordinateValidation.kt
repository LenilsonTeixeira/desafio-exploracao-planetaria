package br.com.lteixeira.msprobe.application.validator.validation

import br.com.lteixeira.msprobe.application.exception.ProbeLandingCartesianCoordinateAreaInvalidException
import br.com.lteixeira.msprobe.domain.AddProbeLandingDomain

class ProbeLandingCartesianCoordinateValidation {

    companion object {
        fun validate(planetCartesianCoodinateArea: Int, probeLanding: AddProbeLandingDomain) {
            if (planetCartesianCoodinateArea < probeLanding.probeLandingCoordinate.locationX ||
                planetCartesianCoodinateArea < probeLanding.probeLandingCoordinate.locationY) {
                throw ProbeLandingCartesianCoordinateAreaInvalidException("As coordenadas de pouso enviadas a sonda: ${probeLanding.probeName} são inválidas")
            }
        }
    }
}