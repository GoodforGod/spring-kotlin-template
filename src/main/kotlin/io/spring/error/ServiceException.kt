package io.spring.error

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

/**
 * @author Anton Kurako (GoodforGod)
 * @since 26.2.2021
 */
open class ServiceException(status: HttpStatus, reason: String?, cause: Throwable?) :
    ResponseStatusException(status, reason, cause) {

    constructor(status: HttpStatus, reason: String?) : this(status, reason, null)
}

class ParamException(message: String) : ServiceException(HttpStatus.BAD_REQUEST, message)

class RequestOverflowException(message: String) : ServiceException(HttpStatus.TOO_MANY_REQUESTS, message)