package com.android.shawnclisby.tilt.network

import com.android.shawnclisby.tilt.data.models.Haul
import retrofit2.http.GET

interface HaulService {

    @GET("hauls")
    suspend fun getHauls(): List<Haul>
}