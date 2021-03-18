package com.bijaya.bookstore.dao

import androidx.room.*
import com.bijaya.bookstore.entity.Product

@Dao
interface ProductDAO {

    @Insert
    suspend fun registerUser(product: Product)

    @Query("Select * from Product")
    suspend fun getProduct():
            List<Product>


    @Delete
    suspend fun DeleteUser(product: Product)

    @Update
    suspend fun UpdateUser(product: Product)
}