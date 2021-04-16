package com.bijaya.bookstore.dao

import androidx.room.*
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.comment

@Dao
interface commentDAO {

    @Insert
    suspend fun registerUser(Comment: comment)

    @Query("Select * from comment")
    suspend fun getProduct():
            List<comment>


    @Delete
    suspend fun DeleteUser(Comment: comment)

    @Update
    suspend fun UpdateUser(comment: comment)
}