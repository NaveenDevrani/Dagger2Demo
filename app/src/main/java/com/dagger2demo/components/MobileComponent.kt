package com.dagger2demo.components

import com.dagger2demo.MainActivity
import com.dagger2demo.classess.Mobile
import com.dagger2demo.moduls.BatteryModule
import com.dagger2demo.moduls.MediaTekModule
import com.dagger2demo.moduls.SnapdragonModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [BatteryModule::class, MediaTekModule::class])
interface MobileComponent {
    fun getMobile(): Mobile // that is called provision method , its identify the method of return type

    fun inject(activity: MainActivity)


//    @Component.Builder
//    interface Builder {
//
//        fun build(): MobileComponent
//
//        @BindsInstance
//        fun setClockSpeed(@Named("speed") clockSpeed: Int): Builder
//
//        @BindsInstance
//        fun setCores(@Named("core") core: Int): Builder
//    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("speed") clockSpeed: Int,@BindsInstance @Named("core") core: Int): MobileComponent

    }
}