package com.homeThunder.data.factory

import com.homeThunder.data.entity.User
import java.util.*

object UserFactory {
    fun create(userState: User.IUserState): User = User(
        id = UUID.randomUUID(),
        state = userState,
    )
}
