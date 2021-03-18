package com.mvvmdaggerroomdb.database

import androidx.room.*
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserModel): Long

    @Query("SELECT *FROM ${AppConstant.TABLE_USER}")
    suspend fun getUserAll(): List<UserModel>?

    @Update
    suspend fun updateUser(user: UserModel): Int

    @Delete
    suspend fun deleteUser(user: UserModel): Int

//    @Query("DELETE FROM ${AppConstant.TABLE_USER}")
//    suspend fun deleteAllUser(user: UserModel): Int
}