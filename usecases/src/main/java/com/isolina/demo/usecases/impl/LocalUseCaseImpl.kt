package com.isolina.demo.usecases.impl

import android.content.Context
import com.isolina.demo.data.repository.LocalRepository
import com.isolina.demo.domain.models.Product
import com.isolina.demo.usecases.LocalUseCase
import javax.inject.Inject

internal class LocalUseCaseImpl @Inject constructor(private val repository: LocalRepository) :
    LocalUseCase {

    override suspend fun executeProducts(): List<Product> {
        return repository.getProducts()
    }

    override suspend fun executeInstance(context: Context): List<Product> {
        return repository.instance(context)
    }

}