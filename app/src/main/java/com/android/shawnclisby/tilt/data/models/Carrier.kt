package com.android.shawnclisby.tilt.data.models

import java.util.*

data class Carrier(
    val name: String,
    val trailer: Trailer,
    val locations: Location,
    val phoneNumber: String,
    val openDate: Date,
    val closeDate: Date
)
