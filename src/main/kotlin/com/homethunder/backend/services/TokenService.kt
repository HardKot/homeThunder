package com.homethunder.backend.services

import com.homethunder.backend.extensions.*
import io.jsonwebtoken.Jwts
import kotlinx.datetime.LocalDateTime
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class JWTService {
    private val signingKey = Jwts.SIG.HS256.key().build()

    fun generateUserIdToken(userId: UUID) = Jwts.builder()
        .subject(userId.toString())
        .signWith(signingKey)
        .expiration((LocalDateTime.now() + 1.Hour).toDate())
        .compact()

    fun getUserIdToken(token: String) = UUID.fromString(
        Jwts.parser()
            .verifyWith(signingKey)
            .build()
            .parseSignedClaims(token)
            .payload
            .subject
    )
}
