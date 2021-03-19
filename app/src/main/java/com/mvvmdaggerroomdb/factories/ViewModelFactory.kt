package com.mvvmdaggerroomdb.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvmdaggerroomdb.repository.AppRepository
import com.mvvmdaggerroomdb.viewmodels.AddDetailViewModel
import com.mvvmdaggerroomdb.viewmodels.DashBoardViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val repository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DashBoardViewModel::class.java) -> DashBoardViewModel(repository) as T
            modelClass.isAssignableFrom(AddDetailViewModel::class.java) -> AddDetailViewModel(repository) as T
            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}
