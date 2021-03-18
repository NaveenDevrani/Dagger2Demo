package com.mvvmdaggerroomdb.dagger.modules

import android.app.Application
import android.content.Context
import com.mvvmdaggerroomdb.dagger.network.MainModule
import com.mvvmdaggerroomdb.database.AppDataBase
import com.mvvmdaggerroomdb.factories.ViewModelFactory
import com.mvvmdaggerroomdb.repository.AppRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [MainModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun getDataBase(): AppDataBase {
        return AppDataBase.invoke()
    }

//    @Provides
//    fun getRepo() = AppRepository(getDataBase())

//    @Provides
//    fun getFactory(): ViewModelFactory {
//        return ViewModelFactory(getRepo())
//    }

}