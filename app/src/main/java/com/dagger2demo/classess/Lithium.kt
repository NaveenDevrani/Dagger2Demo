package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject

class Lithium {

    @Inject
    constructor() {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Lithium constructor ")
    }

    fun done() {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Lithium Done ")
    }
}