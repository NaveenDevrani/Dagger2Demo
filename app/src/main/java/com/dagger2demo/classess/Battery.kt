package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject

class Battery {

//    init {
//        Log.i(AppConstant.KEY_MOBILE_TAG,"Battery constructor ")
//    }

    // for learn provider , let assume this class create by third party we are not created this class constructor so we cannot annotate it with @inject
    @Inject
    constructor(cobalt: Cobalt, lithium: Lithium) {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Battery constructor ")
    }

}