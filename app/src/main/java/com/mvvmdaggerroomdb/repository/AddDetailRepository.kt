package com.mvvmdaggerroomdb.repository

import com.mvvmdaggerroomdb.database.AppDataBase
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.network.ApiService

class AddDetailRepository(private val api: ApiService, private val db: AppDataBase) : BaseRepository() {

    suspend fun saveUser(user: UserModel): Long {
        return db.getUserDao().saveUser(user)
    }

    fun getUser() = db.getUserDao().getUserAll()
}