package com.homethunder.backend.domain.entity

import java.util.UUID

import com.homethunder.backend.domain.table.UserTable
import org.jetbrains.exposed.dao.id.EntityID


class User(
    id: EntityID<UUID>,
) : BaseEntity(id, UserTable) {
    var firstname by UserTable.firstname
    var lastname by UserTable.lastname
    var patronymic by UserTable.patronymic
    var gender by UserTable.gender

    var birthday by UserTable.birthday

    var phone by UserTable.phone
    var email by UserTable.email

    var avatarId by UserTable.avatarId

    fun setPassword(password: String) {
//        dao.passwordSalt = passwordService.generateSalt()
//        dao.password = passwordService.hashPassword(password, dao.passwordSalt)
    }

    fun setAvatar(avatar: ByteArray) {
//        avatarId?.let { mediaContentService.removeFromDisk(it) }
//        dao.avatarId = mediaContentService.writeToDisk(avatar)
    }

    fun dropAvatarId() {
//        dao.avatarId?.let { mediaContentService.removeFromDisk(it) }
//        dao.avatarId = null
    }
}
