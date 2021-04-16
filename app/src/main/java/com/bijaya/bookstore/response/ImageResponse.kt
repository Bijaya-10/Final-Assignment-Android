package com.bijaya.bookstore.response

import com.bijaya.bookstore.entity.Product

data class ImageResponse (
    val success : Boolean?=null,
    val data : Product?=null
)