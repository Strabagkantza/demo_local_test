package com.isolina.demo.data.impl

import android.content.Context
import com.isolina.demo.data.AppData
import com.isolina.demo.data.local.AppDatabase
import com.isolina.demo.data.mapper.convertEntitiesToProducts
import com.isolina.demo.data.mapper.convertProductsToEntities
import com.isolina.demo.data.repository.LocalRepository
import com.isolina.demo.domain.models.Product
import javax.inject.Inject

internal class LocalRepositoryImpl @Inject constructor() : LocalRepository {

    private val app = AppData()
    private lateinit var db: AppDatabase

    override suspend fun instance(context: Context): List<Product> {
        db = app.provideDatabase(context)
        return getProducts()
    }

    override suspend fun getProducts(): List<Product> {
        val productDao = db.productDao()
        val entities = productDao.getAll()
        return convertEntitiesToProducts(entities)
    }

    override suspend fun saveProducts(products: List<Product>) {
        val productDao = db.productDao()
        productDao.deleteAll()
        productDao.insertAll(convertProductsToEntities(products))
    }

}