package com.mvvmdaggerroomdb.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvmdaggerroomdb.activity.AppActivity
import com.mvvmdaggerroomdb.model.UserModel

const val DATABASE_NAME = "myDatabase.db"

@Database(
    entities = [UserModel::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile  //easily visible to all the  other thread
        private var instance: AppDataBase? = null
        private val LOCK = Any() //use lock to make sure we do not create two   instance of our database
        operator fun invoke() = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase().also {
                instance = it
            }
        }

        private fun buildDatabase() =
            Room.databaseBuilder(
                AppActivity.getContext(), AppDataBase::class.java,
                DATABASE_NAME
            ).build()
    }
}