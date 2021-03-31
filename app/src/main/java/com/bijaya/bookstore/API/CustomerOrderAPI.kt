package com.bijaya.bookstore.API

import com.bijaya.bookstore.CustomerOrder
import com.bijaya.bookstore.entity.CustomerOrderEntity
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.response.*
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface CustomerOrderAPI {

    @POST("product/insert")
    suspend fun addProduct(
        @Header("Authorization") token: String,
        @Body product: CustomerOrderEntity
    ): Response<CustomerOrderResponse>

    // get all students
    @GET("product/fetch")
    suspend fun getAllProduct(
        @Header("Authorixation") token: String
    ): Response<CustomerAllOrder>


    //delete student

    @DELETE("product/delete/{id}")
    suspend fun deleteProduct(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<CustomerOrdDelete>


    @Multipart
    @PUT("student/{id}/photo")
    suspend fun uploadImage(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Part file: MultipartBody.Part
    ): Response<ImageResponse>
}