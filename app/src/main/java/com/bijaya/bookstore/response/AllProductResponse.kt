package com.bijaya.bookstore.response

import com.bijaya.bookstore.entity.Product

class AllProductResponse (
    val success: Boolean? = true,
    val count: Int? =0,
    val data: MutableList<Product>? = null
        )