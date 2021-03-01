package com.bijaya.bookstore.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class customer (
    @PrimaryKey(autoGenerate = false)
    val _id : String = "",
    val firstname :String? = null,
    val lastname :String? = null,
    val username :String? = null,
    val password :String? = null

)
