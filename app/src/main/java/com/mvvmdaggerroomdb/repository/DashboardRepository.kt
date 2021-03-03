package com.mvvmdaggerroomdb.repository

class DashboardRepository() : BaseRepository() {
    suspend fun getData(username: String, password: String) =
        safeApiCall {
        }
}