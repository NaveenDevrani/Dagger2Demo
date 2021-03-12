package com.mvvmdaggerroomdb.activity

import android.content.Context
import com.mvvmdaggerroomdb.dagger.component.AppComponent
import com.mvvmdaggerroomdb.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppActivity : DaggerApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        mApplication = this
        appComponent.inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }

    companion object {
        var mApplication: Context? = null
        fun getContext(): Context = mApplication!!.applicationContext
    }
}