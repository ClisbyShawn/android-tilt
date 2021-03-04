package com.android.shawnclisby.tilt.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "_id") val id: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "total_miles") val totalMiles: Int,
    @Json(name = "total_earnings") val totalEarnings: Int,
    @Json(name = "completed_jobs") val completedJobs: Int,
    @Json(name = "current_haul") var haulId: String?
) {
    val formatCompletedJobs: String
        get() = "$completedJobs"

    val formatMilesDriven: String
        get() = String.format("%,d", totalMiles)

    val formatEarnings: String
        get() = String.format("$%,d", totalEarnings)
}