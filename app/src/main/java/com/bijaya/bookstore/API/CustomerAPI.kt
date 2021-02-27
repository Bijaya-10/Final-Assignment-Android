package com.bijaya.bookstore.API

import com.bijaya.bookstore.entity.customer
import com.bijaya.bookstore.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CustomerAPI {
    // Register User
    @POST("/register")

    suspend fun registerUser(
        @Body customer : customer

    ): Response<LoginResponse>

    //Login user
    @FormUrlEncoded
    @POST("/login")

    suspend fun checkUser(
        @Field("username") username : String,
        @Field("password") password : String
    ): Response<LoginResponse>
}