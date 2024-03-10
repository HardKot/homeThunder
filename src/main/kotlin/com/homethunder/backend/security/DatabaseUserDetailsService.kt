package com.homethunder.backend.security

import com.homethunder.backend.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class DatabaseUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        userRepository.findUserByEmail(username)?.let { UserDetailsImpl(it.id, it.email, it.password) }
            ?: throw UsernameNotFoundException("User with email $username not found")

}
