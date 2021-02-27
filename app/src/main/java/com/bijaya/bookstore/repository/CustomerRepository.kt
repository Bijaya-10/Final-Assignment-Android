package com.bijaya.bookstore.repository

import com.bijaya.bookstore.API.CustomerAPI
import com.bijaya.bookstore.API.MyApiRequest
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.customer
import com.bijaya.bookstore.response.LoginResponse

class CustomerRepository     : MyApiRequest() {

    private val customerAPI = ServiceBuilder.buildService(CustomerAPI::class.java)

    suspend fun registerUser(customer: customer): LoginResponse {
        return apiRequest {
            customerAPI.registerUser(customer)
        }
    }

    //login user

    suspend fun checkUser(username :String, password : String) : LoginResponse{
        return apiRequest {
            customerAPI.checkUser(username, password)
        }
    }
}