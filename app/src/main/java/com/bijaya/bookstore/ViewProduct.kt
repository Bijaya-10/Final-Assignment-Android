package com.bijaya.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bijaya.bookstore.adapter.ProductAdapter
import com.bijaya.bookstore.db.ProductDB
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.repository.ProductRepository
import com.bijaya1.weekfiveassignmentone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewProduct : AppCompatActivity() {

    private lateinit var recyclerProduct: RecyclerView;
//    private lateinit var recyclerView: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)
        recyclerProduct = findViewById(R.id.recyclerProduct);
        recyclerProduct.layoutManager = LinearLayoutManager(this@ViewProduct);


loadProducts()
    }
    private fun loadProducts(){
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val productRepository = ProductRepository()
                val response = productRepository.getAllProduct()
                if (response.success == true){
                    val lstProduct = mutableListOf<Product>()
                     lstProduct.addAll(response.data!!)
                    withContext(Dispatchers.Main){
                        val adapter = ProductAdapter(this@ViewProduct,
                        lstProduct!! as ArrayList<Product>
                        )
                        recyclerProduct.adapter =adapter;


                        recyclerProduct.layoutManager = LinearLayoutManager(this@ViewProduct)
                    }
                }
            }catch (ex:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ViewProduct,
                        "Error : ${ex.toString()}",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }











}