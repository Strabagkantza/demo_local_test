package com.isolina.demo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.isolina.demo.data.local.entity.ProductEntity

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<ProductEntity>

    @Insert
    fun insertAll(product: List<ProductEntity>)

    @Query("DELETE FROM product")
    fun deleteAll()
}