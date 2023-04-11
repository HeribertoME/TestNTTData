package com.example.test.data

import com.example.test.Product
import com.example.test.data.responses.ProductsResponse
import retrofit2.Response
import javax.inject.Inject

interface ProductsDataSource {

    //val currentProducts: Flow<List<Product>>

    suspend fun getById(productId: Int): Product?

    suspend fun save(products: ProductsResponse)

    suspend fun getProducts(): Response<ProductsResponse>
}

class ProductsRemoteSource @Inject constructor(
    private val service: ApiService,
) : ProductsDataSource {


    override suspend fun getById(productId: Int): Product? {
        TODO("Not yet implemented")
    }

    override suspend fun save(products: ProductsResponse) {
        TODO("Not yet implemented")
    }

    override suspend fun getProducts() = service.getProducts()

}


