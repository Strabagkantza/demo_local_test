package com.isolina.demo.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id_product: Long = 0,
    val id: String,
    val name: String,
    val details: String,
    val date_unix: Long,
    val date_precision: String,
    val flight_number: Int,
    val success: Boolean,
    val image_small: String,
    val image_large: String
)