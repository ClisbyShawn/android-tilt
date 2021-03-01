package com.android.shawnclisby.tilt.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Carrier(
    val name: String,
    val trailer: Trailer,
    val locations: Location,
    @Json(name = "phone_number") val phoneNumber: String,
    @Json(name = "open_date") val openDate: Long,
    @Json(name = "close_date") val closeDate: Long
)
