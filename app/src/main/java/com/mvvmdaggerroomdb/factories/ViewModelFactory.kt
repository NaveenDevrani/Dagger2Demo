package com.mvvmdaggerroomdb.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvmdaggerroomdb.repository.BaseRepository
import com.mvvmdaggerroomdb.repository.DashboardRepository
import com.mvvmdaggerroomdb.viewmodels.DashBoardViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DashBoardViewModel::class.java) -> DashBoardViewModel(repository as DashboardRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}
