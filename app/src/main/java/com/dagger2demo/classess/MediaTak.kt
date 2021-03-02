package com.dagger2demo.classess

import android.util.Log
import com.dagger2demo.AppConstant
import javax.inject.Inject
import javax.inject.Named

class MediaTak @Inject constructor(@Named("speed") var clockSpeed: Int,@Named("core") var core:Int?) : Processor {


    init {
        Log.i(AppConstant.KEY_MOBILE_TAG, "MediaTak constructor")
    }

    override fun start() {
        Log.i(AppConstant.KEY_MOBILE_TAG, "MediaTak start with $clockSpeed Clock Speed & $core core")
    }
}