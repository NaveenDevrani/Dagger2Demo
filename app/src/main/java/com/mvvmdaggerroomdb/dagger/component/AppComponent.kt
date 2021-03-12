package com.mvvmdaggerroomdb.dagger.component

import android.app.Application
import com.mvvmdaggerroomdb.activity.AppActivity
import com.mvvmdaggerroomdb.activity.DashboardActivity
import com.mvvmdaggerroomdb.dagger.ActivityBuilderModule
import com.mvvmdaggerroomdb.dagger.NetworkModule
import com.mvvmdaggerroomdb.dagger.modules.AppModule
import com.mvvmdaggerroomdb.dagger.modules.ViewModelModule
import com.mvvmdaggerroomdb.factories.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
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
interface AppComponent : AndroidInjector<AppActivity> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}