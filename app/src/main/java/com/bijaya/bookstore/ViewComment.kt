package com.bijaya.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bijaya.bookstore.adapter.ProductAdapter
import com.bijaya.bookstore.adapter.commentAdapter
import com.bijaya.bookstore.db.ProductDB
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.comment
import com.bijaya.bookstore.repository.CustomerRepository
import com.bijaya.bookstore.repository.ProductRepository
import com.bijaya.bookstore.repository.commentRepository
import com.bijaya1.weekfiveassignmentone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewComment : AppCompatActivity() {

    private lateinit var recyclerProduct: RecyclerView;
//    private lateinit var recyclerView: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_comment)
        recyclerProduct = findViewById(R.id.recyclerProduct);
        recyclerProduct.layoutManager = LinearLayoutManager(this@ViewComment);


        loadProducts()
    }
    private fun loadProducts(){
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val CommentRepository = commentRepository()
                val response = CommentRepository.getAllProduct()
                if (response.success == true){
                    val lstProduct = response.data
                    withContext(Dispatchers.Main){
                        recyclerProduct.adapter = commentAdapter(this@ViewComment,
                            lstProduct!! as ArrayList<comment>
                        )
                        recyclerProduct.layoutManager = LinearLayoutManager(this@ViewComment)
                    }
                }
            }catch (ex:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ViewComment,
                        "Error : ${ex.toString()}",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }











}