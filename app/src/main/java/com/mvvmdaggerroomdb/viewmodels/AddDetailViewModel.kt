package com.mvvmdaggerroomdb.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dagger2demo.R
import com.mvvmdaggerroomdb.model.CountryModel
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.repository.AppRepository
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.util.Coroutines
import com.mvvmdaggerroomdb.util.Util
import com.mvvmdaggerroomdb.util.Util.getString
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddDetailViewModel @Inject constructor(private val repository: AppRepository?) : ViewModel() {
    var validationError: MutableLiveData<String> = MutableLiveData()
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
                validationError.postValue(AppConstant.KEY_NAME)
                false
            }

            userModel.address.isNullOrEmpty() -> {
                validationError.postValue(AppConstant.KEY_ADDRESS)
                false
            }
            userModel.country.isNullOrEmpty() -> {
                validationError.postValue(AppConstant.KEY_COUNTRY)
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
                    Util.showToast(getString(R.string.user_save_message))
                } else {
                    successObserver.postValue(false)
                    Util.showToast(getString(R.string.something_wrong_error))
                }
            }
        }
    }

    private fun updateData() {
        Coroutines.main {
            val result = repository?.updateUser(userModel)
            result?.let {
                if (result > 0) {
                    successObserver.postValue(true)
                    Util.showToast(getString(R.string.user_update_message))
                } else {
                    successObserver.postValue(false)
                    Util.showToast(getString(R.string.something_wrong_error))
                }
            }
        }
    }

    fun getCountriesList() {
        val disposable = repository?.getCountry()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.map {
                it.result
            }?.subscribe({ data ->
                countryObserver.postValue(data)
            }, {
                Log.e("country exception", "country-> ${it.printStackTrace()}")
            })
        disposable?.let { compositeDisposable.add(it) }
    }

}