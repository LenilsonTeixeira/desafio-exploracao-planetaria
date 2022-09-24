package br.com.lteixeira.msprobe.application.enumeration

import br.com.lteixeira.msprobe.application.exception.DirectionInvalidException

enum class Direction(val key: String) {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    companion object {
        fun fromKey(name: String): Direction =
            Direction.values().find { value -> value.key == name } ?: throw DirectionInvalidException("Direção inválida")
    }
}