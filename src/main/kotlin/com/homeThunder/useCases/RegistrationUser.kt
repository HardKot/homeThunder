package com.homeThunder.useCases

import com.homeThunder.data.entity.User
import com.homeThunder.data.enums.Gender
import com.homeThunder.repository.dao.UserDAO
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable


class RegistrationUser (
    private val userDAO: UserDAO
){
    public suspend fun run(form: CreateUserForm): User {
        var user: User? = UserDAO.findByEmail(form.email)
        if (user != null) throw Exception("User with email ${form.email} already exists")
        if (form.phone != null && UserDAO.findByPhone(form.phone) != null) throw Exception("User with phone ${form.phone} already exists")

        user = UserDAO.createByForm(form)

        user.setPassword(form.password)

        return user
    }

    @Serializable
    data class CreateUserForm(
        val firstname: String,
        val lastname: String,
        val patronymic: String?,
        val gender: Gender,
        val birthday: LocalDate?,

        val phone: String?,
        val email: String,

        val password: String,
    )



}
