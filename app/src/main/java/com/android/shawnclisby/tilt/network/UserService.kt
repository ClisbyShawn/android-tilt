package com.android.shawnclisby.tilt.network

import com.android.shawnclisby.tilt.data.models.User
import retrofit2.http.GET

interface UserService {

    @GET("me")
    suspend fun getUser(): List<User>
}