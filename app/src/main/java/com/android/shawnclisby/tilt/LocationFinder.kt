package com.android.shawnclisby.tilt

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.util.*

object LocationFinder {

    private var geoCoder: Geocoder? = null
    private var addresses: List<Address> = emptyList()

    fun setUpGeoCoder(context: Context) {
        geoCoder = Geocoder(context, Locale.getDefault())
    }

    fun setLocation(city: Map<String, Double>) {
        addresses = geoCoder?.getFromLocation(
            city["lat"]!!, city["lon"]!!, 1
        )!!
    }

    val address: String
        get() = addresses[0].getAddressLine(0)

    val city: String
        get() = addresses[0].locality

    val state: String
        get() = addresses[0].adminArea

    val postalCode: String
        get() = addresses[0].postalCode

}