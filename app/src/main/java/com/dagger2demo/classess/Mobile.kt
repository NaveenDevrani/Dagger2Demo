package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject

class Mobile @Inject constructor(private val battery: Battery, private val processor: Processor) {

    init {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Mobile constructor ")
    }

    fun run() {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Mobile Run ")
    }
}