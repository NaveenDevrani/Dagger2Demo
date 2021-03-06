package com.mvvmdaggerroomdb.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.repository.AppRepository
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.util.Coroutines
import com.mvvmdaggerroomdb.util.Util

class AddDetailViewModel(private val repository: AppRepository?) : ViewModel() {
    var validationError: MutableLiveData<Int> = MutableLiveData()
    var successObserver: MutableLiveData<Boolean> = MutableLiveData()
    var userModel = UserModel()


    fun onSubmit(view: View) {
        if (validation())
            saveData()
    }

    private fun validation(): Boolean {
        return when {
            userModel.name.isNullOrEmpty() -> {
                validationError.postValue(1)
                false
            }

            userModel.address.isNullOrEmpty() -> {
                validationError.postValue(2)
                false
            }
            else -> true
        }
    }

    private fun saveData() {
        Coroutines.main {
            val result = repository?.saveUser(userModel)
            result?.let {
                if (result > 0) {
                    successObserver.postValue(true)
                    Util.showToast(AppConstant.USER_SAVE_MESSAGE)
                } else Util.showToast(AppConstant.SOMETHING_WRONG_MESSAGE)
            }
        }
    }

}