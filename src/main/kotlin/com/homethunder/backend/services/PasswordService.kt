package com.homethunder.backend.services

import at.favre.lib.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.security.SecureRandom


@Service
class PasswordService {
    private val random = SecureRandom()
    private val bcrypr = BCrypt.withDefaults()
    private val verifyer = BCrypt.verifyer()

    fun generateSalt(): ByteArray {
        val salt = ByteArray(16)
        random.nextBytes(salt)
        return salt
    }

    fun hashPassword(password: String, salt: ByteArray): ByteArray {
        return bcrypr.hash(cost, salt, password.toByteArray())
    }

    fun isExpectedPassword(password: String, salt: ByteArray, expectedHash: ByteArray): Boolean {
        return verifyer.verify(password.toByteArray(), cost, salt, expectedHash).verified
    }

    companion object {
        private const val cost = 6
    }
}
