package com.bijaya.bookstore.API

import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.comment
import com.bijaya.bookstore.response.*
import okhttp3.MultipartBody
import org.w3c.dom.Comment
import retrofit2.Response
import retrofit2.http.*

interface commentAPI {

    @POST("product/insert")
    suspend fun addProduct(
        @Header("Authorization") token : String,
        @Body Comment : comment
    ) : Response<addcmntResponse>

    // get all students
    @GET("product/fetch")
    suspend fun getAllProduct(
        @Header("Authorixation") token : String
    ) : Response<allcmntResponse>


    //delete student

    @DELETE("product/delete/{id}")
    suspend fun deleteProduct(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ):Response<deletecmntResponse>


    @Multipart
    @PUT("student/{id}/photo")
    suspend fun uploadImage(
        @Header("Authorization") token: String,
        @Path ("id") id:String,
        @Part file: MultipartBody.Part
    ):Response<ImageResponse>
}


