package com.isolina.demo.data.remote

import com.isolina.demo.data.base.BaseRemoteDataSource
import com.isolina.demo.data.remote.service.ApiService
import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Product
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryDataSource @Inject constructor(
    private val apiService: ApiService, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun products(): Output<List<Product>> {
        return getResponse(
            request = { apiService.products() },
            defaultErrorMessage = "C'è stato un errore. Ti preghiamo di riprovare"
        )
    }
}