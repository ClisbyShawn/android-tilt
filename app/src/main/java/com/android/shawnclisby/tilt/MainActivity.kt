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
            println("Live City: ${hauls[0].carrier.locations.oCity}")
            println("Live City: ${hauls[0].carrier.locations.dCity}")
            println("Live Address: ${hauls[0].carrier.locations.oAddress}")
            println("Live Address: ${hauls[0].carrier.locations.dAddress}")
            println("Live State: ${hauls[0].carrier.locations.oState}")
            println("Live State: ${hauls[0].carrier.locations.dState}")
            println("Live Postal Code: ${hauls[0].carrier.locations.oPostalCode}")
            println("Live Postal Code: ${hauls[0].carrier.locations.dPostalCode}")
        }
    }
}