package io.spring.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * @author Anton Kurako (GoodforGod)
 * @since 24.2.2021
 */
@RestController
@RequestMapping("/")
class Controller {

    fun get(): Mono<String> {
        return Mono.just("ok")
    }
}
