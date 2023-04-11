package com.example.test.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.NetworkResult
import com.example.test.data.responses.ProductsResponse
import com.example.test.domain.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProducts: GetProducts
) : ViewModel() {

    private var _response = MutableLiveData<NetworkResult<ProductsResponse>>()
    val response: LiveData<NetworkResult<ProductsResponse>> = _response

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            getProducts().collect() {
                _response.postValue(it)
            }
        }
    }

}