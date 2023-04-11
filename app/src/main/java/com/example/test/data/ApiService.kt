package com.example.test.data

import com.example.test.data.responses.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts() : Response<ProductsResponse>

}
