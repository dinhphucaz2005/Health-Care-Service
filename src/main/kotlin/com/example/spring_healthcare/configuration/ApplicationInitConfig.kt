package com.example.spring_healthcare.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class ApplicationInitConfig @Autowired constructor(
    private val passwordEncoder: PasswordEncoder
) {
    @Bean
    fun applicationRunner(): ApplicationRunner {
        return ApplicationRunner { _ ->
        }
    }
}
