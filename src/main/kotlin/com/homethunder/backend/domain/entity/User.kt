package com.homethunder.backend.domain.entity

import com.homethunder.backend.domain.enums.Gender
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID,

    var firstname: String,
    var lastname: String,
    var patronymic: String?,

    var gender: Gender = Gender.Unknown,

    var birthday: LocalDate,
    var email: String,
    @Column(name = "avatar_id") var avatarId: UUID?,

    var password: ByteArray,

    @Column(name = "updated_at") var updateAt: LocalDateTime,
    @Column(name = "created_at") var createAt: LocalDateTime,
) {
    fun dropAvatar() {
        avatarId = null
    }
}
