package com.mvvmdaggerroomdb.repository

import com.mvvmdaggerroomdb.database.AppDataBase

class DashboardRepository(val dataBase: AppDataBase) : BaseRepository() {
    suspend fun getAllUser() = dataBase.getUserDao().getUserAll()
}