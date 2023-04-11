package com.example.test.utils

import com.example.test.Product

fun com.example.test.data.responses.Product.toProductUI(): Product {
    return Product(
        id = this.id ?: 0,
        name = this.title ?: "",
        description = this.description ?: "",
        price = this.price.toString()
    )
}

fun String.formatName(): String {
    return "Nombre: $this"
}

fun String.formatPrice(): String {
    return "Precio: $this"
}