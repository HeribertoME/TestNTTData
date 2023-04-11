package com.example.test.di

import com.example.test.data.ApiService
import com.example.test.data.ProductsDataSource
import com.example.test.data.ProductsRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideProductsDataSource(apiService: ApiService): ProductsDataSource = ProductsRemoteSource(apiService)

}