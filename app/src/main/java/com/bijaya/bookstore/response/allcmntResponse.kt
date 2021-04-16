package com.bijaya.bookstore.response

import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.comment

class allcmntResponse (
    val success: Boolean? = true,
    val count: Int? =0,
    val data: MutableList<comment>? = null
)