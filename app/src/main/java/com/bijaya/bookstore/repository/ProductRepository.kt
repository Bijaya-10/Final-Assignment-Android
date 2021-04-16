package com.bijaya.bookstore.repository

import com.bijaya.bookstore.API.MyApiRequest
import com.bijaya.bookstore.API.ProductAPI
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.response.AddProductResponse
import com.bijaya.bookstore.response.AllProductResponse
import com.bijaya.bookstore.response.DeleteProductResponse
import com.bijaya.bookstore.response.ImageResponse
import okhttp3.MultipartBody

class ProductRepository: MyApiRequest() {

    private val productAPI =
        ServiceBuilder.buildService(ProductAPI::class.java)


    //Add Student

    suspend fun addProduct(product: Product): AddProductResponse {
        return apiRequest {
            productAPI.addProduct(
                ServiceBuilder.token!!, product
            )
        }
    }
//    suspend fun addImage(product: Product): AddProductResponse {
//        return apiRequest {
//            productAPI.addImage(
//                ServiceBuilder.token!!, product
//            )
//        }
//    }

    suspend fun getAllProduct(): AllProductResponse {
        return apiRequest {
            productAPI.getAllProduct(
                ServiceBuilder.token!!
            )
        }
    }

    suspend fun deleteProduct(id: String): DeleteProductResponse {
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


