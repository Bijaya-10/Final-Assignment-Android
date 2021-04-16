package com.bijaya.bookstore.repository

import com.bijaya.bookstore.API.MyApiRequest
import com.bijaya.bookstore.API.ProductAPI
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.API.commentAPI
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.comment
import com.bijaya.bookstore.response.*
import okhttp3.MultipartBody

class commentRepository: MyApiRequest() {

    private val productAPI =
        ServiceBuilder.buildService(commentAPI::class.java)


    //Add Student

    suspend fun addProduct(Comment: comment): addcmntResponse {
        return apiRequest {
            productAPI.addProduct(
                ServiceBuilder.token!!, Comment
            )
        }
    }

    suspend fun getAllProduct(): allcmntResponse {
        return apiRequest {
            productAPI.getAllProduct(
                ServiceBuilder.token!!
            )
        }
    }

    suspend fun deleteProduct(id: String): deletecmntResponse {
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


