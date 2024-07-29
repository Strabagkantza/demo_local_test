package com.isolina.demo.data

import android.content.Context
import androidx.room.Room
import com.isolina.demo.data.local.AppDatabase
import com.isolina.demo.data.local.DatabaseProvider

class AppData: DatabaseProvider {

    override fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "demo-db"
        ).allowMainThreadQueries().build()
    }

}