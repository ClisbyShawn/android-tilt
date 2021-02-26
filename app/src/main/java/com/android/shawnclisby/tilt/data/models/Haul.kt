package com.android.shawnclisby.tilt.data.models

import java.text.DateFormat
import java.text.DateFormat.LONG
import java.text.DateFormat.MEDIUM
import java.util.*

data class Haul(
    val carrier: Carrier,
    val publishedDate: Date
)
{
    fun formatPublishDate(): String {
        val format = DateFormat.getDateInstance(MEDIUM)
        return format.format(Calendar.getInstance().setTime(publishedDate))
    }

    fun formatOpenDate(): String {
        val format = DateFormat.getDateInstance(LONG)
        return format.format(Calendar.getInstance().setTime(carrier.openDate))
    }

    fun formatCloseDate(): String {
        val format = DateFormat.getDateInstance(LONG)
        return format.format(Calendar.getInstance().setTime(carrier.closeDate))
    }

}
