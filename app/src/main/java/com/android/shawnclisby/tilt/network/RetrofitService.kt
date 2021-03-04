package com.android.shawnclisby.tilt.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.212:5000/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val haulService: HaulService = retrofit.create(HaulService::class.java)

    val userService: UserService = retrofit.create(UserService::class.java)
}