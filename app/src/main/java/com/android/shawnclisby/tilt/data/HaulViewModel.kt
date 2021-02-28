package com.android.shawnclisby.tilt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.shawnclisby.tilt.data.models.Carrier
import com.android.shawnclisby.tilt.data.models.Haul
import com.android.shawnclisby.tilt.data.models.Location
import com.android.shawnclisby.tilt.data.models.Trailer
import java.util.*

class HaulViewModel : ViewModel() {


    private val haul = Haul(
        carrier = Carrier(
            name = "JMC",
            trailer = Trailer(
                weight = 15000,
                description = "Big ass trailer",
                notes = "need double straps"
            ),
            locations = Location(
                originCity = mapOf("lon" to -79.827230, "lat" to 40.407090),
                destinationCity = mapOf("lon" to -122.084068, "lat" to 37.423199)
            ),
            phoneNumber = "(412)359 - 9218",
            openDate = Date(),
            closeDate = Date()
        ),
        publishedDate = Date()
    )

    private val _haulList = MutableLiveData(listOf(haul))
    val haulList: LiveData<List<Haul>> = _haulList
}