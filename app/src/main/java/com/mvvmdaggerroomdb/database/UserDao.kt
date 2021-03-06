package com.mvvmdaggerroomdb.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.mvvmdaggerroomdb.model.CURRENT_USER_ID
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserModel): Long

    @Query("SELECT *FROM ${AppConstant.TABLE_USER}")
    suspend fun getUserAll():List<UserModel>?

//    @Query("SELECT *FROM ${AppConstant.TABLE_USER} WHERE id=$CURRENT_USER_ID")
//    fun getUser(): MutableLiveData<UserModel?>

    @Update
    fun updateUser(user: UserModel)

    @Delete
    fun deleteUser(user: UserModel)
}