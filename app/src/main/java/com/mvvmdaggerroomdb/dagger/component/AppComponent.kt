package com.mvvmdaggerroomdb.dagger.component

import android.app.Application
import com.mvvmdaggerroomdb.activity.AndroidApplication
import com.mvvmdaggerroomdb.dagger.ActivityBuilderModule
import com.mvvmdaggerroomdb.dagger.NetworkModule
import com.mvvmdaggerroomdb.dagger.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        NetworkModule::class]
)
interface AppComponent : AndroidInjector<AndroidApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}