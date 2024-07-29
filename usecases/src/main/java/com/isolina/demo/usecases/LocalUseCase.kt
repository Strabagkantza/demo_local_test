package com.isolina.demo.usecases

import android.content.Context
import com.isolina.demo.domain.models.Product

interface LocalUseCase {
    suspend fun executeProducts(): List<Product>
    suspend fun executeInstance(context: Context): List<Product>
}