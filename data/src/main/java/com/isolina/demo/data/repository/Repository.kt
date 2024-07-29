package com.isolina.demo.data.repository

import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Product

interface Repository {
    suspend fun products(): Output<List<Product>> = products()
}