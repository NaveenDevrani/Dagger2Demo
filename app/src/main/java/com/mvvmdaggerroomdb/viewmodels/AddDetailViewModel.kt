package com.mvvmdaggerroomdb.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmdaggerroomdb.model.CountryModel
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.repository.AppRepository
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.util.Coroutines
import com.mvvmdaggerroomdb.util.Util
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddDetailViewModel(private val repository: AppRepository?) : ViewModel() {
    var validationError: MutableLiveData<Int> = MutableLiveData()
    var successObserver: MutableLiveData<Boolean> = MutableLiveData()
    var countryObserver: MutableLiveData<List<CountryModel>> = MutableLiveData()
    var userModel = UserModel()
    var isEdit = false

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onSubmit(view: View) {
        if (validation()) {
            if (isEdit)
                updateData()
            else saveData()
        }
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

    private fun updateData() {
        Coroutines.main {
            val result = repository?.updateUser(userModel)
            result?.let {
                if (result > 0) {
                    successObserver.postValue(true)
                    Util.showToast(AppConstant.USER_UPDATE_MESSAGE)
                } else Util.showToast(AppConstant.SOMETHING_WRONG_MESSAGE)
            }
        }
    }

    fun getCountriesList() {
        val disposable = repository?.getCountry()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.map {
                // Use this space to play around with the response
                it.result
            }
            ?.subscribe({ data ->
                // Receives final response
                countryObserver.postValue(data)
            }, {
                Log.e("country exception", "country-> ${it.printStackTrace()}")
                // Receives Error Exception
            })
        disposable?.let { compositeDisposable.add(it) }
    }

}