package com.mvvmdaggerroomdb.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mvvmdaggerroomdb.model.CURRENT_USER_ID
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserModel): Long

    @Query("SELECT *FROM ${AppConstant.TABLE_USER}")
    fun getUserAll(): LiveData<UserModel>

    @Query("SELECT *FROM ${AppConstant.TABLE_USER} WHERE id=$CURRENT_USER_ID")
    fun getUser(): LiveData<UserModel>

    @Update
    fun updateUser(user: UserModel)

    @Delete
    fun deleteUser(user: UserModel)
}