package com.android.shawnclisby.tilt.network

import com.android.shawnclisby.tilt.data.models.Haul
import retrofit2.http.GET
import retrofit2.http.POST

interface HaulService {

    @GET("hauls")
    suspend fun getHauls(): List<Haul>

    @POST("hauls/new")
    suspend fun newHaul()
}