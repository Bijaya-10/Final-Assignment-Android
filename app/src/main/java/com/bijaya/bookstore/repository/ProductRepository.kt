package com.bijaya.bookstore.repository

import com.bijaya.bookstore.API.MyApiRequest
import com.bijaya.bookstore.API.ProductAPI
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.response.AddProductResponse

class ProductRepository :    MyApiRequest() {
    private val studentAPI =
        ServiceBuilder.buildService(ProductAPI::class.java)

    // Add Student
    suspend fun addProduct(product : Product) : AddProductResponse{
        return apiRequest {
            studentAPI.addProduct(ServiceBuilder.token!!,product)
        }
    }
}
