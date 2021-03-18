package com.mvvmdaggerroomdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.repository.AppRepository
import com.mvvmdaggerroomdb.repository.DashboardRepository
import com.mvvmdaggerroomdb.util.Coroutines
import javax.inject.Inject

class DashBoardViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {

    var progressBarObserver: MutableLiveData<Boolean> = MutableLiveData()
    var userList: MutableLiveData<List<UserModel>> = MutableLiveData()
    var deleteUserObserver: MutableLiveData<Boolean> = MutableLiveData()

    fun getUserList(): LiveData<List<UserModel>> = userList

    fun getUser() {
        progressBarObserver.postValue(true)
        Coroutines.main {
            val userLists = repository.getAllUser()
            userList.postValue(userLists)
            progressBarObserver.postValue(false)
        }
    }

    fun deleteUser(user: UserModel) {
        progressBarObserver.postValue(true)
        Coroutines.main {
            repository.deleteUser(user)
            deleteUserObserver.postValue(true)
            progressBarObserver.postValue(false)
        }
    }

}