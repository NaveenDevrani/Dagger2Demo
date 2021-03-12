package com.mvvmdaggerroomdb.dagger

import javax.inject.Scope

/**

 * This class is holds the custom annotation made to be used in the project for dependency injection.
 */

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AdapterScope