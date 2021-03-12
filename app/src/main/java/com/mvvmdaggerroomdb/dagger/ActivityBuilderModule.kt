package com.mvvmdaggerroomdb.dagger

import com.mvvmdaggerroomdb.activity.AddDetailActivity
import com.mvvmdaggerroomdb.activity.DashboardActivity
import com.mvvmdaggerroomdb.activity.ShowDetailActivity
import com.mvvmdaggerroomdb.dagger.modules.subModules.AddDetailActivityModule
import com.mvvmdaggerroomdb.dagger.modules.subModules.DashBoardActivityModule
import com.mvvmdaggerroomdb.dagger.modules.subModules.ShowDetailActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This class is dagger module and is used to get Reference of the all the activities in the project.
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [DashBoardActivityModule::class])
    abstract fun provideMainActivity(): DashboardActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AddDetailActivityModule::class])
    abstract fun provideAddDetailActivity(): AddDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ShowDetailActivityModule::class])
    abstract fun provideShowDetailActivity(): ShowDetailActivity
}