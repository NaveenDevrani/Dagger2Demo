package com.mvvmdaggerroomdb.repository

import com.mvvmdaggerroomdb.database.AppDataBase
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.network.ApiService

class AppRepository(private val api: ApiService, private val db: AppDataBase) : BaseRepository() {

    suspend fun saveUser(user: UserModel): Long {
        return db.getUserDao().saveUser(user)
    }


    suspend fun getAllUser() = db.getUserDao().getUserAll()

}