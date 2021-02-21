package com.bijaya.bookstore.dao

import androidx.room.*
import com.bijaya.bookstore.entity.Customer

@Dao
interface UserDAO {
    @Insert
    suspend fun  registerUser(customer: Customer)

    @Query("select * from Customer where username=(:username) and password=(:password)")
    suspend fun  loginUser(username :String,password:String) : Customer



}