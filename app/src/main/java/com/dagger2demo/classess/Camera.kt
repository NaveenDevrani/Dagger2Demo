package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject
import javax.inject.Named

class Camera @Inject constructor( var megabyte: Int) {

    init {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Camera start with $megabyte ")
    }
}