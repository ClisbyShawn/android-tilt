package com.android.shawnclisby.tilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.shawnclisby.tilt.data.HaulViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModels: HaulViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModels = ViewModelProvider(this).get(HaulViewModel::class.java)

        viewModels.haulList.observe(this) { hauls ->
            hauls?.forEach { haul ->
                println("Live Origin City: ${haul.carrier.locations.oCity}")
                println("Live Origin Address: ${haul.carrier.locations.oAddress}")

                println("Live Destination City: ${haul.carrier.locations.dCity}")
                println("Live Destination Address: ${haul.carrier.locations.dAddress}")

                println("Live Published Date: ${haul.formattedPublishDate}")
                println("Live Open Date: ${haul.formattedOpenDate}")
                println("Live Close Date: ${haul.formattedCloseDate}")

                println("Live Weight: ${haul.carrier.trailer.weight}")
                println("Live Description: ${haul.carrier.trailer.description}")
                println("Live Notes: ${haul.carrier.trailer.notes}")
            }
        }
    }
}