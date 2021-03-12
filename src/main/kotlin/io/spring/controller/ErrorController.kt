package io.spring.controller

import io.spring.model.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.ResponseStatusException
import java.util.concurrent.TimeoutException

/**
 * @author GoodforGod
 * @since 28.02.2021
 */
@ControllerAdvice
class ErrorController {

    @ExceptionHandler
    fun handleResponseExceptions(e: ResponseStatusException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(e.status)
            .contentType(MediaType.APPLICATION_JSON)
            .body(ErrorResponse(e.status.value(), e.reason))
    }

    @ExceptionHandler
    fun handleTimeoutExceptions(e: TimeoutException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.REQUEST_TIMEOUT)
            .contentType(MediaType.APPLICATION_JSON)
            .body(ErrorResponse(HttpStatus.REQUEST_TIMEOUT.value(), e.message))
    }
}