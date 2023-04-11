package com.example.test.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.data.responses.Product
import com.example.test.R
import com.example.test.databinding.ProductItemBinding
import com.example.test.utils.formatName
import com.example.test.utils.formatPrice

class ProductsAdapter(
    private val onProductClick: (Product) -> Unit
) : ListAdapter<Product, ProductViewHolder>(ProductDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position), onProductClick)
    }

}

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ProductItemBinding.bind(view)

    fun bind(product: Product, onProductClick: (Product) -> Unit) {
        binding.tvNameItem.text = product.title?.formatName()
        binding.tvDescriptionItem.text = product.description
        binding.tvPriceItem.text = product.price.toString().formatPrice()
        binding.root.setOnClickListener { onProductClick(product) }
    }
}