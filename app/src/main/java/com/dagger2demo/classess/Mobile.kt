package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject

class Mobile {
    private lateinit var battery: Battery
    private lateinit var processor: Processor

    @Inject
    constructor(battery: Battery, processor: Processor) {
        this.battery = battery
        this.processor = processor
    }

    init {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Mobile constructor ")
    }

    fun run() {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Mobile Run ")
        processor.start()
    }

    @Inject  //this is method injection
    fun connectCharger(charger: Charger) {
        charger.setCharger(this)
    }
}