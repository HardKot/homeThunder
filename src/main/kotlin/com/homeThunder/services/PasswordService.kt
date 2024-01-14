package com.homeThunder.services

import at.favre.lib.crypto.bcrypt.BCrypt
import java.security.SecureRandom


object PasswordService {

    private val random = SecureRandom()
    private val bcrypr = BCrypt.withDefaults()
    private val verifyer = BCrypt.verifyer()
    private const val cost = 6

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
}
