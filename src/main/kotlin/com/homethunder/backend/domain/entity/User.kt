package com.homethunder.backend.domain.entity

import com.homethunder.backend.domain.enums.Gender
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID = UUID.randomUUID(),

    var firstname: String,
    var lastname: String,
    var patronymic: String? = null,

    @Enumerated(EnumType.STRING)
    var gender: Gender = Gender.Unknown,

    var birthday: LocalDate,
    var email: String,

    var password: String,

    @Column(name = "updated_at") var updateAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "created_at") var createAt: LocalDateTime = LocalDateTime.now(),
) {
}
