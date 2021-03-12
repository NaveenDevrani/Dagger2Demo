package com.mvvmdaggerroomdb.repository

import com.mvvmdaggerroomdb.database.AppDataBase
import com.mvvmdaggerroomdb.model.CountryResponseModel
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.network.api.main.MainApiImpl
import io.reactivex.Single
import javax.inject.Inject

class AppRepository @Inject constructor(private val mainApi: MainApiImpl, private val db: AppDataBase) {

    suspend fun saveUser(user: UserModel): Long {
        return db.getUserDao().saveUser(user)
    }

    suspend fun updateUser(user: UserModel): Int {
        return db.getUserDao().updateUser(user)
    }

    suspend fun deleteUser(user: UserModel): Int {
        return db.getUserDao().deleteUser(user)
    }

    suspend fun getAllUser() = db.getUserDao().getUserAll()

    fun getCountry(): Single<CountryResponseModel> {
        return mainApi.getCountry()
    }

}