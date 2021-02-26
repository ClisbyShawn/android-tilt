package com.android.shawnclisby.tilt.data

import androidx.lifecycle.ViewModel
import com.android.shawnclisby.tilt.data.models.Carrier
import com.android.shawnclisby.tilt.data.models.Haul
import com.android.shawnclisby.tilt.data.models.Location
import com.android.shawnclisby.tilt.data.models.Trailer
import java.util.*

class HaulViewModel : ViewModel() {

    init {
        val haul = Haul(
            carrier = Carrier(
                name="JMC",
                trailer = Trailer(
                    weight = 15000,
                    description = "Big ass trailer",
                    notes = "need double straps"
                ),
                locations = Location(
                    originCity = mapOf("lon" to 43.45, "lat" to -73.459),
                    destinationCity = mapOf("lon" to 43.45, "lat" to -73.459)
                ),
                phoneNumber = "(412) 359-9218",
                openDate = Date(),
                closeDate = Date()
            ),
            publishedDate = Date()
        )

        haul.formatPublishDate()
        haul.formatOpenDate()
        haul.formatCloseDate()
    }
}