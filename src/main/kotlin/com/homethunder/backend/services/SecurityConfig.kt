package com.homethunder.backend.services


import com.homethunder.backend.security.DatabaseUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val databaseUserDetailsService: DatabaseUserDetailsService
) {
//    @Bean
//    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager =
//        authenticationConfiguration.authenticationManager

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    @Primary
    fun configurationManagerBuilder(authenticationManagerBuilder: AuthenticationManagerBuilder): AuthenticationManagerBuilder {
        authenticationManagerBuilder
            .userDetailsService(databaseUserDetailsService)
            .passwordEncoder(passwordEncoder())
        return authenticationManagerBuilder
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf { disable() }
            httpBasic { disable() }
            authorizeHttpRequests {
                authorize(anyRequest, permitAll)
//                authorize(anyRequest, authenticated)
                }
        }
        return http.build()
    }
}
