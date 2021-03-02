package com.mvvmdaggerroomdb.repository

import com.mvvmdaggerroomdb.repository.BaseRepository

class DashboardRepository() : BaseRepository() {
    suspend fun login(username: String, password: String) =
        safeApiCall {
//            api.login(username, password)
        }
}