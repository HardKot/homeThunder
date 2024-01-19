package com.homeThunder.database.dao

import com.homeThunder.database.baseEntity.BaseEntity
import com.homeThunder.database.baseEntity.BaseEntityClass
import com.homeThunder.database.tables.UserPasswordTable
import com.homeThunder.database.tables.UserTable
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*
import javax.inject.Inject

class UserDAO @Inject constructor(id: EntityID<UUID>) : BaseEntity(id, UserTable) {
    companion object : BaseEntityClass<UserDAO>(UserTable)

    var firstname by UserTable.firstname
    var lastname by UserTable.lastname
    var patronymic by UserTable.patronymic
    var gender by UserTable.gender

    var birthday by UserTable.birthday

    var phone by UserTable.phone
    var email by UserTable.email

    var avatarId by UserTable.avatarId

    var password by UserPasswordTable.password
    var salt by UserPasswordTable.salt
}
