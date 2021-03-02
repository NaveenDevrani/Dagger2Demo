package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject
import javax.inject.Named

class Snapdragon @Inject constructor(@Named("speed") val clockSpeed: Int,@Named("core") val core: Int) : Processor {

    override fun start() {
        Log.i(AppConstant.KEY_MOBILE_TAG, "Snapdragon start with $clockSpeed clock speed and $core core")
    }

}