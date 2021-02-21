package com.bijaya.bookstore.API

import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.response.AddProductResponse
import com.bijaya.bookstore.response.AllProductResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ProductAPI {

    @POST("insertproduct/")
    suspend fun addProduct(
        @Header("Authorization") token : String,
        @Body product : Product
    ) : Response<AddProductResponse>

    // get all students
    @GET("getproduct/")
    suspend fun getAllProduct(
        @Header("Authorixation") token : String
    ) : Response<AllProductResponse>
}