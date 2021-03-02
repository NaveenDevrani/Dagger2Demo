package com.dagger2demo.moduls

import com.dagger2demo.classess.MediaTak
import com.dagger2demo.classess.Processor
import dagger.Binds
import dagger.Module

@Module
public abstract class MediaTekModule {

    @Binds
    abstract fun getProcessor(mediaTak: MediaTak): Processor
}