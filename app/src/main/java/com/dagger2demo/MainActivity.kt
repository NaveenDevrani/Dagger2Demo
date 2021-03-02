package com.dagger2demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dagger2demo.classess.Mobile
import com.dagger2demo.components.DaggerMobileComponent
import com.dagger2demo.components.MobileComponent
import com.dagger2demo.moduls.SnapdragonModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject  // this is field injection
    lateinit var mobile: Mobile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mobile = Mobile(Battery(), Processor())// in the dagger we are not creating the constructor like this
        val component = DaggerMobileComponent.factory().create(2,4)
//            .setClockSpeed(11)
//            .setCores(2)
//            .build()
        component.inject(this)
        mobile?.run()
    }
}