package br.com.lteixeira.msprobe.application.enumeration

import br.com.lteixeira.msprobe.application.exception.CommandInvalidException

enum class Command(val key: Char) {
    LEFT('L'),
    RIGHT('R'),
    MOVE('M');

    companion object {
        fun fromKey(key: Char): Command =
            values().find {value -> value.key == key } ?: throw CommandInvalidException("Comando inválido")
    }
}