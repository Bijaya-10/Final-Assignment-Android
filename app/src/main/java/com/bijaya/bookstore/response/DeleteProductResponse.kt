package com.bijaya.bookstore.response

import com.bijaya.bookstore.entity.Product

data class DeleteProductResponse (
    val success : Boolean?=null,
    val data : Product?=null
)