package com.dagger2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dagger2demo.classess.Battery
import com.dagger2demo.classess.Mobile
import com.dagger2demo.classess.Processor
import com.dagger2demo.components.MobileComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mobile = Mobile(Battery(), Processor())
        val component=Mobile
    }
}