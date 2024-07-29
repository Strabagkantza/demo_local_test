package com.isolina.demo.data.repository

import android.content.Context
import com.isolina.demo.domain.models.Product

interface LocalRepository {
    suspend fun getProducts(): List<Product> = getProducts()
    suspend fun saveProducts(products: List<Product>) { saveProducts(products) }
    suspend fun instance(context: Context): List<Product> = instance(context)
}