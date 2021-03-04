package com.android.shawnclisby.tilt.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.text.DateFormat
import java.text.DateFormat.LONG
import java.text.DateFormat.MEDIUM
import java.util.*

@JsonClass(generateAdapter = true)
data class Haul(
    @Json(name = "_id")val id:String,
    val carrier: Carrier,
    @Json(name = "publish_date") val publishedDate: Long
) {

    val formattedPublishDate: String
        get() = DateFormat.getDateInstance(MEDIUM).format(Date(publishedDate * 1000L))

    val formattedOpenDate: String
        get() = DateFormat.getDateInstance(LONG).format(Date(carrier.openDate * 1000L))


    val formattedCloseDate: String
        get() = DateFormat.getDateInstance(LONG).format(Date(carrier.closeDate * 1000L))


}
