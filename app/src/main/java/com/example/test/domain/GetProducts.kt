package com.example.test.domain

import com.example.test.Product
import com.example.test.data.NetworkResult
import com.example.test.data.ProductsRepository
import com.example.test.data.responses.ProductsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class GetProducts @Inject constructor(
    private val productsRepository: ProductsRepository
){

    suspend operator fun invoke(): Flow<NetworkResult<ProductsResponse>> = productsRepository.getProducts()
}