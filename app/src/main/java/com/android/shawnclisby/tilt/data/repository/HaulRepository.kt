package com.android.shawnclisby.tilt.data.repository

import com.android.shawnclisby.tilt.data.models.Haul
import com.android.shawnclisby.tilt.network.HaulService
import com.android.shawnclisby.tilt.network.RetrofitService

class HaulRepository(
    private val haulService: HaulService = RetrofitService.haulService
) {

    suspend fun fetchHauls(): List<Haul> = haulService.getHauls()

    suspend fun newHaulItem() = haulService.newHaul()
}