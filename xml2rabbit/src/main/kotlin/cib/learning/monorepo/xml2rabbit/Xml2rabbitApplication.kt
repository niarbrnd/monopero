package cib.learning.monorepo.xml2rabbit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.integration.config.EnableIntegration

@SpringBootApplication
@Configuration
@ImportResource("appConfig.xml")
@EnableIntegration
class Xml2rabbitApplication

fun main(args: Array<String>) {
    runApplication<Xml2rabbitApplication>(*args)
}
