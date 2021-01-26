package com.dagger2demo.components

import com.dagger2demo.classess.Battery
import com.dagger2demo.classess.Mobile
import com.dagger2demo.classess.Processor
import dagger.Component

@Component(modules = [Battery::class, Processor::class])
public interface MobileComponent {
    fun getMobile(): Mobile
}