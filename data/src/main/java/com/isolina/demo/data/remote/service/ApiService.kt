package com.isolina.demo.data.remote.service

import com.isolina.demo.domain.models.Product
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("launches")
    suspend fun products(): Response<List<Product>>

}