package com.dagger2demo.moduls

import com.dagger2demo.classess.Battery
import com.dagger2demo.classess.Cobalt
import com.dagger2demo.classess.Lithium
import dagger.Module
import dagger.Provides

@Module
object BatteryModule {

    @Provides // this is help to inject the third party class
    @JvmStatic
    fun getCobalt(): Cobalt {
        return Cobalt()
    }

    @Provides
    @JvmStatic
    fun getLithium(): Lithium {
        val lithium = Lithium()
        lithium.done()
        return lithium
    }

    @Provides
    @JvmStatic
    fun getBattery(lithium: Lithium, cobalt: Cobalt):Battery {
        return Battery(lithium = lithium, cobalt = cobalt)
    }
}