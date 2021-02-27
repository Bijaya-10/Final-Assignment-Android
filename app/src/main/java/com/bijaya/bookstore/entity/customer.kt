package com.bijaya.bookstore.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class customer (

    val _id : String? = null,
    val firstname :String? = null,
    val lastname :String? = null,
    val username :String? = null,
    val password :String? = null


        )
