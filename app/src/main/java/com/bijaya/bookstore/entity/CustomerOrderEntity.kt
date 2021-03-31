package com.bijaya.bookstore.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CustomerOrderEntity  (

    val _id: String? = null,
    val Book_Name: String? = null,
    val Book_Number: String? = null,
    val Book_Image: String? = null
)
{
    @PrimaryKey(autoGenerate = true)
    var productId:Int? = null;
}
