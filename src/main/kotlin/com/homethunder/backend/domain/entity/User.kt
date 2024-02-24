package com.homethunder.backend.domain.entity

import java.util.UUID

import com.homethunder.backend.domain.table.UsersTable
import org.jetbrains.exposed.dao.id.EntityID

class User(
    id: EntityID<UUID>,
) : BaseEntity(id, UsersTable) {

    companion object : BaseEntityClass<User>(UsersTable)

    var firstname by UsersTable.firstname
    var lastname by UsersTable.lastname
    var patronymic by UsersTable.patronymic
    var gender by UsersTable.gender

    var birthday by UsersTable.birthday

    var email by UsersTable.email
    var password by UsersTable.password
    var passwordSalt by UsersTable.passwordSalt

    var avatarId by UsersTable.avatarId

    fun dropAvatarId() {
        avatarId = null
    }
}
