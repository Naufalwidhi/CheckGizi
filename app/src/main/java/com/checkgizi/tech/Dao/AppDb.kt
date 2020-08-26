package com.checkgizi.tech.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.checkgizi.tech.Model.DataAnak2

@Database(entities = [DataAnak2::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}

object AppDb{

    fun getDB(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "DataAnak"
    )
        .allowMainThreadQueries()
        .build()

}