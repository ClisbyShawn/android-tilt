package com.android.shawnclisby.tilt

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.util.*

object LocationFinder {

    private var geoCoder: Geocoder? = null
    private var addresses: List<Address>? = null

    fun setUpGeoCoder(context: Context) {
        geoCoder = Geocoder(context, Locale.getDefault())
    }

    fun setLocation(city: Map<String, Double>) {
        addresses = geoCoder?.getFromLocation(
            city["lat"]!!, city["lon"]!!, 1
        )!!
    }

    val address: String
        get() = addresses?.get(0)?.getAddressLine(0) ?: "Couldn't find exact location"

    val city: String
        get() = addresses?.get(0)?.locality ?: "Couldn't find exact location"

    val state: String
        get() = addresses?.get(0)?.adminArea ?: "Couldn't find exact location"

    val postalCode: String
        get() = addresses?.get(0)?.postalCode ?: "Couldn't find exact location"

}