package com.example.test.data

import com.example.test.data.responses.ProductsResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class ProductsRepository @Inject constructor(
    private val productsDataSource: ProductsDataSource
) : BaseApiResponse() {

    suspend fun getProducts(): Flow<NetworkResult<ProductsResponse>> {
        return flow<NetworkResult<ProductsResponse>> {
            emit(safeApiCall { productsDataSource.getProducts() })
        }.flowOn(Dispatchers.IO)
    }

}