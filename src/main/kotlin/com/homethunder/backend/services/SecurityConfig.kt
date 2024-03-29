package com.homethunder.backend.services


import com.homethunder.backend.security.DatabaseUserDetailsService
import com.homethunder.backend.web.views.AuthView
import com.vaadin.flow.spring.security.VaadinWebSecurity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val databaseUserDetailsService: DatabaseUserDetailsService
) : VaadinWebSecurity() {
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

    override fun configure(http: HttpSecurity) {
        http.authorizeHttpRequests(Customizer { auth ->
            auth.requestMatchers(AntPathRequestMatcher("/resources/**"))
                .permitAll()
            auth.requestMatchers(AntPathRequestMatcher("/main.jpg"))
                .permitAll()
        })

        super.configure(http)

        setLoginView(http, AuthView::class.java)
    }

    public override fun configure(web: WebSecurity?) {
        super.configure(web)
    }
}
