package com.mvvmdaggerroomdb.dagger.modules.subModules

import com.mvvmdaggerroomdb.dagger.FragmentScope
import com.mvvmdaggerroomdb.fragment.AddDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This class is dagger module and is used to get Reference of the 'AddDetailFragment' related fragments.
 */

@Module
abstract class AddDetailActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindAddDetailFragment(): AddDetailFragment
}