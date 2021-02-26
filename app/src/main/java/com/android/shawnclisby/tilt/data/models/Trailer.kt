package com.android.shawnclisby.tilt.data.models

data class Trailer(
    val weight: Int,
    val description: String,
    val notes:String?
)
{
    val formattedWeight: String
        get() = String.format("%,d lbs",weight)
}
