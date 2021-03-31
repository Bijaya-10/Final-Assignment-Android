package com.bijaya.bookstore.response

import com.bijaya.bookstore.entity.Product

class CustomerOrderResponse(
    val success : Boolean? = null,
    val data : Product? = null
)