package com.example.soraew

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class WearOsActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wear_os)
        setAmbientEnabled()
    }
}