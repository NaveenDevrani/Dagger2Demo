package com.mvvmdaggerroomdb.dagger.modules.subModules


import com.mvvmdaggerroomdb.dagger.FragmentScope
import com.mvvmdaggerroomdb.fragment.DashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This class is dagger module and is used to get Reference of the 'MainActivity' related fragments.
 */

@Module
abstract class DashBoardActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDashboardFragment(): DashboardFragment
}