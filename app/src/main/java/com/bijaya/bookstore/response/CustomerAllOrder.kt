package com.bijaya.bookstore.response

import com.bijaya.bookstore.entity.CustomerOrderEntity
import com.bijaya.bookstore.entity.Product

class CustomerAllOrder(
    val success: Boolean? = true,
    val count: Int? =0,
    val data: MutableList<CustomerOrderEntity>? = null
)