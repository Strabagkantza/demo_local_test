package com.isolina.demo.data.impl

import com.isolina.demo.data.remote.RepositoryDataSource
import com.isolina.demo.data.repository.LocalRepository
import com.isolina.demo.data.repository.Repository
import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Product
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val repositoryDataSource: RepositoryDataSource,
    private val localRepository: LocalRepository
) : Repository {
    private fun convertToProductList(anyList: List<Any>): List<Product> {
        return anyList.mapNotNull { item ->
            if (item is Product) {
                item
            } else {
                println("Skipping item: $item as it is not of type Product")
                null
            }
        }
    }
    override suspend fun products(): Output<List<Product>> {
        val products = repositoryDataSource.products()
        if (products.status == Output.Status.SUCCESS) {
            products.data?.let {
                localRepository.saveProducts(it)
            }
        }
        return products
    }
}