package com.bijaya.bookstore.repository

import com.bijaya.bookstore.API.CustomerOrderAPI
import com.bijaya.bookstore.API.MyApiRequest
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.CustomerOrderEntity
import com.bijaya.bookstore.response.*
import okhttp3.MultipartBody

class CustomerOrderRepo: MyApiRequest() {

    private val productAPI =
        ServiceBuilder.buildService(CustomerOrderAPI::class.java)


    //Add Student

    suspend fun addProduct(product: CustomerOrderEntity): CustomerOrderResponse {
        return apiRequest {
            productAPI.addProduct(
                ServiceBuilder.token!!, product
            )
        }
    }

    suspend fun getAllProduct(): CustomerAllOrder {
        return apiRequest {
            productAPI.getAllProduct(
                ServiceBuilder.token!!
            )
        }
    }

    suspend fun deleteProduct(id: String): CustomerOrdDelete {
        return apiRequest {
            productAPI.deleteProduct(
                ServiceBuilder.token!!,id
            )
        }
    }
    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            productAPI.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }


}


