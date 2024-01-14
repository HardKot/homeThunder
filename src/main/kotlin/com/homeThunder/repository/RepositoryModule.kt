package com.homeThunder.repository

import com.homeThunder.data.entity.User
import com.homeThunder.repository.dao.UserDAO
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun userState(userDAO: UserDAO): User.IUserState
}
