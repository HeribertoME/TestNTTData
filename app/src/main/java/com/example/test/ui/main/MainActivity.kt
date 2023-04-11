package com.example.test.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.test.R
import com.example.test.data.NetworkResult
import com.example.test.databinding.ActivityMainBinding
import com.example.test.ui.detail.DetailActivity
import com.example.test.utils.toProductUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productsAdapter: ProductsAdapter

    private val vm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            productsAdapter = ProductsAdapter(
                onProductClick = {
                    DetailActivity.navigate(this@MainActivity, it)
                }
            )
            rvMain.adapter = productsAdapter

            vm.response.observe(this@MainActivity) {
                when(it) {
                    is NetworkResult.Loading -> {}
                    is NetworkResult.Error -> {
                        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
                    }
                    is NetworkResult.Success -> productsAdapter.submitList(it.data?.products)
                }
            }
        }
    }

}