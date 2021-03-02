package com.dagger2demo.moduls

import com.dagger2demo.classess.Processor
import com.dagger2demo.classess.Snapdragon
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class SnapdragonModule(@Named("speed")var clockSpeed: Int, @Named("core") var core: Int) {

    @Provides
    fun getProcessor(snapdragon: Snapdragon): Processor {
        return snapdragon
    }

//    @Provides
//    fun getProcessor(): Processor {
//        return Snapdragon(clockSpeed)
//    }


    @Provides
    fun getClockSpeeds(@Named("speed") clockSpeed: Int): Int { // if the class need the integer value then the class use this integer value
        return clockSpeed
    }

    @Provides
    fun getCores(@Named("core") clockSpeed: Int): Int {
        return core
    }

}