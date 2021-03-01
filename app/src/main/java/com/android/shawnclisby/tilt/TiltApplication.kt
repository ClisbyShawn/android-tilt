package com.android.shawnclisby.tilt

import android.app.Application

class TiltApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        LocationFinder.setUpGeoCoder(this)
    }
}