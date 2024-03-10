package com.homethunder.backend.repository

import com.homethunder.backend.domain.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : CrudRepository<User, UUID> {
    fun findUserByEmail(email: String): User?
}
