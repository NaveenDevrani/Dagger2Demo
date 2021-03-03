package com.mvvmdaggerroomdb.activity

import android.app.Application
import android.content.Context

class AppActivity : Application() {
    override fun onCreate() {
        super.onCreate()
        mApplication = this
    }

    companion object {
        var mApplication: Context? = null
        fun getContext(): Context = mApplication!!.applicationContext
    }
}