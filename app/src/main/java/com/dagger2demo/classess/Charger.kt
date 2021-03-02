package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject

class Charger {
    @Inject
    constructor() {
        Log.i(AppConstant.KEY_MOBILE_TAG, "charger constructor ")
    }

    fun setCharger(mobile:Mobile){
        Log.i(AppConstant.KEY_MOBILE_TAG, "Mobile charging ")
    }
}