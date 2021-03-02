package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject

//class Processor @Inject constructor() {
//
//    init {
//        Log.i(AppConstant.KEY_MOBILE_TAG, "Process constructor ")
//    }
//}

// now we consider the processor class is interface
interface Processor {
    fun start()
}