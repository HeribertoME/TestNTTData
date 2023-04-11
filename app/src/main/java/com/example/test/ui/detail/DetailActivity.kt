package com.example.test.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.test.data.responses.Product
import com.example.test.databinding.ActivityDeatilBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM = "item"

        fun navigate(activity: AppCompatActivity, product: Product) {
            val intent = Intent(activity, DetailActivity::class.java).apply {
                putExtra(EXTRA_ITEM, product)
            }
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityDeatilBinding.inflate(layoutInflater).apply {
            setContentView(root)
            val product = intent.getSerializableExtra(EXTRA_ITEM) as Product
            tvTitle.text = product.title

            Glide
                .with(this@DetailActivity)
                .load(product.images.getOrNull(0))
                .centerCrop()
                .into(image)

            tvDescription.text = product.description

            tvPrice.text = product.price.toString()

            textButton.setOnClickListener {
                finish()
            }


        }
    }
}