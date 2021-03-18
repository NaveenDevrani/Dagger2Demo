package com.mvvmdaggerroomdb.dagger.modules.subModules


import com.mvvmdaggerroomdb.dagger.FragmentScope
import com.mvvmdaggerroomdb.fragment.AddDetailFragment
import com.mvvmdaggerroomdb.fragment.DashboardFragment
import com.mvvmdaggerroomdb.fragment.ShowDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This class is dagger module and is used to get Reference of the 'ShowDetailFragment' related fragments.
 */

@Module
abstract class ShowDetailActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindShowDetailFragment(): ShowDetailFragment
}