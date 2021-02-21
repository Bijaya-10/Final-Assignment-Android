package com.bijaya.bookstore.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer (

    val firstname :String? = null,
    val lastname :String? = null,
    val username :String? = null,
    val password :String? = null

        )


{
    @PrimaryKey(autoGenerate = true)
    var userId : Int = 0
}