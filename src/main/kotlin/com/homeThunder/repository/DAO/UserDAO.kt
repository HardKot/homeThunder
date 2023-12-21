package com.homeThunder.repository.DAO

import com.homeThunder.data.entity.User
import com.homeThunder.repository.UserTable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDAO(entityID: EntityID<Int>) : IntEntity(entityID), User {
    companion object : IntEntityClass<UserDAO>(UserTable)

    override val ID: Int = entityID.value

    override var firstname: String by UserTable.firstname
        private set

    override var lastname: String by UserTable.lastname
        private set

    override var patronymic: String? by UserTable.patronymic
        private set

    override var birthday: LocalDate? by UserTable.birthday
        private set

    override var phone: String? by UserTable.phone
        private set

    override var email: String by UserTable.email
        private set

    override var password: String by UserTable.password
        private set

    override var salt: String by UserTable.salt
        private set

    override val createAt: LocalDateTime by UserTable.createAt
    override val updateAt: LocalDateTime by UserTable.updateAt

}
