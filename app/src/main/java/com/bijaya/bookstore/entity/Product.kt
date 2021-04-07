package com.bijaya.bookstore.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(

    val _id: String? = null,
    val Customer_Name: String? = null,
    val Customer_Address: String? = null,
    val Customer_Book: String? = null,
    val Customer_Email: String? = null,

    val Book_Image: String? = null
)
{
    @PrimaryKey(autoGenerate = true)
    var productId:Int? = null;
}