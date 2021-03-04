package com.android.shawnclisby.tilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging

private const val TOPIC = "/topics/hauls"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance()
            .subscribeToTopic(TOPIC)

        supportActionBar?.hide()
    }
}