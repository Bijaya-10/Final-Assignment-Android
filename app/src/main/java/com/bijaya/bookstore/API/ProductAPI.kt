package com.bijaya.bookstore.API

import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.response.AddProductResponse
import com.bijaya.bookstore.response.AllProductResponse
import com.bijaya.bookstore.response.DeleteProductResponse
import com.bijaya.bookstore.response.ImageResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ProductAPI {

    @POST("order/insert")
    suspend fun addProduct(
        @Header("Authorization") token : String,
        @Body product : Product
    ) : Response<AddProductResponse>

    // get all students
    @GET("order/fetch")
    suspend fun getAllProduct(
        @Header("Authorixation") token : String
    ) : Response<AllProductResponse>


    //delete student

    @DELETE("order/delete/{id}")
    suspend fun deleteProduct(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ):Response<DeleteProductResponse>


    @Multipart
    @PUT("student/{id}/photo")
    suspend fun uploadImage(
        @Header("Authorization") token: String,
        @Path ("id") id:String,
        @Part file: MultipartBody.Part
    ):Response<ImageResponse>
}


