package com.homeThunder.repository.dao

import com.homeThunder.data.entity.User
import com.homeThunder.repository.baseEntity.BaseEntity
import com.homeThunder.repository.baseEntity.BaseEntityClass
import com.homeThunder.repository.tables.UserPasswordTable
import com.homeThunder.repository.tables.UserTable
import com.homeThunder.useCases.RegistrationUser
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*
import javax.inject.Inject

class UserDAO @Inject constructor(id: EntityID<UUID>) : BaseEntity(id, UserTable), User.IUserState {
    companion object : BaseEntityClass<UserDAO>(UserTable) {
        fun findByEmail(email: String): User? {
            return findOne { UserTable.email eq email } .firstOrNull()?.toUser()
        }

        fun findByPhone(phone: String): User? {
            return findOne { UserTable.phone eq phone } .firstOrNull()?.toUser()
        }

        fun createByForm(form: RegistrationUser.CreateUserForm): User = new {
            firstname = form.firstname
            lastname = form.lastname
            patronymic = form.patronymic
            gender = form.gender
            birthday = form.birthday
            phone = form.phone
            email = form.email
        } .toUser()
    }

    override var firstname by UserTable.firstname
    override var lastname by UserTable.lastname
    override var patronymic by UserTable.patronymic
    override var gender by UserTable.gender

    override var birthday by UserTable.birthday

    override var phone by UserTable.phone
    override var email by UserTable.email

    override var avatarId by UserTable.avatarId

    override var password by UserPasswordTable.password
    override var salt by UserPasswordTable.salt

    fun toUser() = User(id.value, this)
}
