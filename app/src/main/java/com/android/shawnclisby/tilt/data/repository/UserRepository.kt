package com.android.shawnclisby.tilt.data.repository

import com.android.shawnclisby.tilt.network.RetrofitService
import com.android.shawnclisby.tilt.network.UserService

class UserRepository(
    private val userService: UserService = RetrofitService.userService
) {

    suspend fun fetchUser() = userService.getUser()

}