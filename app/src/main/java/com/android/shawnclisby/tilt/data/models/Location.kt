package com.android.shawnclisby.tilt.data.models

import com.android.shawnclisby.tilt.LocationFinder

data class Location(
    val originCity: Map<String, Double>,
    val destinationCity: Map<String, Double>,
) {

    val oAddress: String
        get() = {
            LocationFinder.setLocation(originCity)
            LocationFinder.address
        }()

    val dAddress: String
        get() = {
            LocationFinder.setLocation(destinationCity)
            LocationFinder.address
        }()

    val oCity: String
        get() = {
            LocationFinder.setLocation(originCity)
            LocationFinder.city
        }()

    val dCity: String
        get() = {
            LocationFinder.setLocation(destinationCity)
            LocationFinder.city
        }()

    val oState: String
        get() = {
            LocationFinder.setLocation(originCity)
            LocationFinder.state
        }()

    val dState: String
        get() = {
            LocationFinder.setLocation(destinationCity)
            LocationFinder.state
        }()

    val oPostalCode: String
        get() = {
            LocationFinder.setLocation(originCity)
            LocationFinder.postalCode
        }()

    val dPostalCode: String
        get() = {
            LocationFinder.setLocation(destinationCity)
            LocationFinder.postalCode
        }()
}