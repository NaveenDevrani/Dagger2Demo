package com.dagger2demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dagger2demo.components.MobileComponent

class MainActivity : AppCompatActivity() {
    var daggerMobileComponent: MobileComponent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mobile = Mobile(Battery(), Processor())// in the dagger we are not creating the constructor like this
//        daggerMobileComponent = DaggerMobileComponent()
    }
}