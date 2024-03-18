package com.homethunder.backend.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

class UserDetailsImpl(
    var uid: UUID,
    email: String,
    password: String,
    authorities: Collection<GrantedAuthority> = emptyList()
) : User(email, password, authorities), UserDetails {

}
