package com.bijaya.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bijaya.bookstore.adapter.CommentAdapter

import com.bijaya.bookstore.entity.CustomerOrderEntity
import com.bijaya.bookstore.repository.CustomerOrderRepo
import com.bijaya1.weekfiveassignmentone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewCustomerOrder : AppCompatActivity() {

    private lateinit var recyclerProduct: RecyclerView;
//    private lateinit var recyclerView: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_customer_order)
        recyclerProduct = findViewById(R.id.recyclerProduct);
        recyclerProduct.layoutManager = LinearLayoutManager(this@ViewCustomerOrder);


        loadProducts()
    }
    private fun loadProducts(){
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val customerorderRepository = CustomerOrderRepo()
                val response = customerorderRepository.getAllProduct()
                if (response.success == true){
                    val lstProduct = response.data
                    withContext(Dispatchers.Main){
                        recyclerProduct.adapter = CommentAdapter(this@ViewCustomerOrder,
                            lstProduct!! as ArrayList<CustomerOrderEntity>
                        )
                        recyclerProduct.layoutManager = LinearLayoutManager(this@ViewCustomerOrder)
                    }
                }
            }catch (ex:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ViewCustomerOrder,
                        "Error : ${ex.toString()}",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}