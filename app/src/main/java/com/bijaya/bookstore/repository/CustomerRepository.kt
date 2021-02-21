package com.bijaya.bookstore.repository

import com.bijaya.bookstore.API.CustomerAPI
import com.bijaya.bookstore.API.MyApiRequest
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.Customer
import com.bijaya.bookstore.response.LoginResponse

class CustomerRepository     : MyApiRequest() {

    private val userAPI = ServiceBuilder.buildService(CustomerAPI::class.java)

    suspend fun registerUser(customer: Customer): LoginResponse {
        return apiRequest {
            userAPI.registerUser(customer)
        }
    }

    //login user

    suspend fun checkUser(username :String, password : String) : LoginResponse{
        return apiRequest {
            userAPI.checkUser(username, password)
        }
    }
}