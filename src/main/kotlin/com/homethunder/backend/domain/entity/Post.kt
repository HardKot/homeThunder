package com.homethunder.backend.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*


@Entity
@Table(name = "posts")
data class Post(
    @Id
    @GeneratedValue
    var id: UUID = UUID.randomUUID(),

    var title: String,
    var content: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,

    var visible: Boolean = true,

    @Column(name = "updated_at") var updateAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "created_at") var createAt: LocalDateTime = LocalDateTime.now(),
    )
