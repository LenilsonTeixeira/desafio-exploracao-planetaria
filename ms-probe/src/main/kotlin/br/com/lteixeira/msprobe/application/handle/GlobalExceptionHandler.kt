package br.com.lteixeira.msprobe.application.handle

import br.com.lteixeira.msprobe.application.handle.model.ErrorResponse
import br.com.lteixeira.msprobe.application.handle.model.FieldResponse
import br.com.lteixeira.msprobe.application.exception.BaseException
import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.Instant
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class GlobalExceptionHandler {

    companion object {
        private const val INVALID_MESSAGE = "Atributos inválidos"
        private const val INVALID_BODY = "Body inválido"
        private const val INVALID_CONTENT_TYPE = "Content-Type inválido"
        private const val INCOMPATIBLE_TYPE = "Tipos incompatíveis"
        private const val MISSING_HEADER = "Header obrigatório não informado"
        private const val MISSING_PARAM = "Parâmetro obrigatório não informado"
    }

    @ExceptionHandler
    fun handleBaseException(exception: BaseException, request: HttpServletRequest): ErrorResponse {
        return ErrorResponse(
            message = exception.message,
            status = exception.getStatus().value(),
            error = exception.getStatus().name,
            path = request.servletPath,
            timestamp = Instant.now().toEpochMilli()
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception, request: HttpServletRequest): ErrorResponse {
        return ErrorResponse(
            message = HttpStatus.INTERNAL_SERVER_ERROR.name,
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            path = request.servletPath,
            timestamp = Instant.now().toEpochMilli()
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleHttpMessageNotReadableException(
        exception: HttpMessageNotReadableException,
        request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(
            message = INVALID_BODY,
            status = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            error = exception.message ?: HttpStatus.UNPROCESSABLE_ENTITY.name,
            timestamp = Instant.now().toEpochMilli(),
            path = request.servletPath
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleHttpMediaTypeNotSupportedException(
        exception: HttpMediaTypeNotSupportedException,
        request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(
            message = INVALID_CONTENT_TYPE,
            status = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            error = exception.message ?: HttpStatus.UNPROCESSABLE_ENTITY.name,
            timestamp = Instant.now().toEpochMilli(),
            path = request.servletPath
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMissingServletRequestParameterException(
        exception: MissingServletRequestParameterException,
        request: HttpServletRequest
    ): ErrorResponse {
        val field = FieldResponse(
            message = MISSING_PARAM,
            field = exception.parameterName,
        )

        return ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            path = request.servletPath,
            error = HttpStatus.BAD_REQUEST.name,
            timestamp = Instant.now().toEpochMilli(),
            message = MISSING_PARAM,
            fields = mutableSetOf(field)
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMissingRequestHeaderException(
        exception: MissingRequestHeaderException,
        request: HttpServletRequest
    ): ErrorResponse {
        val field = FieldResponse(
            message = MISSING_HEADER,
            field = exception.headerName,
        )

        return ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            path = request.servletPath,
            error = HttpStatus.BAD_REQUEST.name,
            timestamp = Instant.now().toEpochMilli(),
            message = MISSING_HEADER,
            fields = mutableSetOf(field)
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleTypeMismatchException(exception: TypeMismatchException, request: HttpServletRequest): ErrorResponse {
        val field = FieldResponse(
            message = INCOMPATIBLE_TYPE,
            field = exception.propertyName!!,
            value = exception.value
        )

        return ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            path = request.servletPath,
            error = HttpStatus.BAD_REQUEST.name,
            timestamp = Instant.now().toEpochMilli(),
            message = MISSING_PARAM,
            fields = mutableSetOf(field)
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBindException(exception: BindException, request: HttpServletRequest): ErrorResponse {
        val fields = exception.bindingResult.fieldErrors.map {
            FieldResponse(
                message = it.defaultMessage!!,
                field = it.field,
                value = it.rejectedValue
            )
        }.toMutableSet()

        return ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            path = request.servletPath,
            timestamp = Instant.now().toEpochMilli(),
            error = exception.message,
            message = INVALID_MESSAGE,
            fields = fields
        )
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleArgumentNotValidException(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorResponse {
        val fields = exception.bindingResult.fieldErrors.map {
            FieldResponse(
                message = it.defaultMessage!!,
                field = it.field,
                value = it.rejectedValue!!
            )
        }.toMutableSet()

        return ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            path = request.servletPath,
            timestamp = Instant.now().toEpochMilli(),
            error = HttpStatus.BAD_REQUEST.name,
            message = INVALID_MESSAGE,
            fields = fields
        )

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleConstraintViolationException(
        exception: ConstraintViolationException,
        request: HttpServletRequest
    ): ErrorResponse {

        val fields = exception.constraintViolations.map {

            var fieldName: String? = null

            for (node in it.propertyPath) {
                fieldName = node.name
            }

            FieldResponse(
                message = it.message,
                field = fieldName!!,
                value = it.invalidValue!!
            )
        }.toMutableSet()

        return ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            path = request.servletPath,
            timestamp = Instant.now().toEpochMilli(),
            error = HttpStatus.BAD_REQUEST.name,
            message = INVALID_MESSAGE,
            fields = fields
        )
    }
}

