package com.bijaya.bookstore.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Product(
    @PrimaryKey(autoGenerate = false)
    val _id: String = "",
    val Customer_Name: String? = null,
    val Customer_Address: String? = null,
    val Customer_Book: String? = null,
    val Customer_Email: String? = null,

    val Book_Image: String? = null
):Serializable
