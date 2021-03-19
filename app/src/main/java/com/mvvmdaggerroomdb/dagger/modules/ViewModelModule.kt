package com.mvvmdaggerroomdb.dagger.modules

import androidx.lifecycle.ViewModelProvider
import com.mvvmdaggerroomdb.factories.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.NewInstanceFactory
}