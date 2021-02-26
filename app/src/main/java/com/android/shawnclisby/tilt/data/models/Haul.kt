package com.android.shawnclisby.tilt.data.models

import java.text.DateFormat
import java.text.DateFormat.LONG
import java.text.DateFormat.MEDIUM
import java.util.*

data class Haul(
    val carrier: Carrier,
    val publishedDate: Date
) {

    val formattedPublishDate: String
        get() = DateFormat.getDateInstance(MEDIUM).format(publishedDate)

    val formattedOpenDate: String
        get() = DateFormat.getDateInstance(LONG).format(carrier.openDate)


    val formattedCloseDate: String
        get() = DateFormat.getDateInstance(LONG).format(carrier.closeDate)


}
