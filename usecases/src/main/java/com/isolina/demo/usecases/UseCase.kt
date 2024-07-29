package com.isolina.demo.usecases

import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Product

interface UseCase {
    suspend fun executeProducts(): Output<List<Product>>
}