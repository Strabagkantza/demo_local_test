package com.isolina.demo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.isolina.demo.data.local.dao.ProductDao
import com.isolina.demo.data.local.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}