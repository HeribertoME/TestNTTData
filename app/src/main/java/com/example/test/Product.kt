package com.example.test

import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: String
) : Serializable