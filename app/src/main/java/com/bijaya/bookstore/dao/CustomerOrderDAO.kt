package com.bijaya.bookstore.dao

import androidx.room.*

import com.bijaya.bookstore.entity.CustomerOrderEntity


@Dao
interface CustomerOrderDAO {

    @Insert
    suspend fun registerUser(product: CustomerOrderEntity)

    @Query("Select * from CustomerOrderEntity")
    suspend fun getProduct():
            List<CustomerOrderEntity>


    @Delete
    suspend fun DeleteUser(product: CustomerOrderEntity)

    @Update
    suspend fun UpdateUser(product: CustomerOrderEntity)
}