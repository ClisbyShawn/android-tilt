package com.android.shawnclisby.tilt.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Trailer(
    val weight: Int,
    val description: String,
    val notes: String?
) {
    val formattedWeight: String
        get() = String.format("%,d lbs", weight)
}
