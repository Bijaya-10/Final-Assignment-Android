package com.bijaya.bookstore.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.bijaya.bookstore.entity.Product

interface ProductDAO {

    @Insert
    suspend fun  registerUser(product : Product)


    @Delete
    suspend fun  DeleteUser(product: Product)

    @Update
    suspend fun  UpdateUser(product: Product)
}