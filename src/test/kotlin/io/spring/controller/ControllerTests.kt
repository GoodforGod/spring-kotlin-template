package io.spring.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

/**
 * @author Anton Kurako (GoodforGod)
 * @since 26.2.2021
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTests(@Autowired val restTemplate: TestRestTemplate) : Assertions() {

    private val path = "/"

    @Test
    fun success() {
        val entity = restTemplate.getForEntity<String>(path)
        assertEquals(HttpStatus.OK, entity.statusCode)
    }
}