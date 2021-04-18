package com.bijaya.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.repository.ProductRepository
import com.bijaya1.weekfiveassignmentone.R
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class updateactivity : AppCompatActivity() {

    private lateinit var etname: EditText
    private lateinit var etemail: EditText
    private lateinit var etbook: EditText
    private lateinit var etaddress: EditText


    private lateinit var btnsave: Button
    private lateinit var imgProfile: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateactivity)

        etname = findViewById(R.id.etname)
        etbook = findViewById(R.id.etbook)
        etaddress = findViewById(R.id.etaddress)
        etemail = findViewById(R.id.etemail)

        btnsave = findViewById(R.id.btnsave)

        imgProfile = findViewById(R.id.imgProfile)
        var id = "";

        val intent = intent;
        if (intent.extras != null) {
             id = intent.getStringExtra("_id").toString();
            etname.setText(intent.getStringExtra("name"));
            etbook.setText(intent.getStringExtra("book"));
            etaddress.setText(intent.getStringExtra("address"));
            etemail.setText(intent.getStringExtra("email"));
            val image = intent.getStringExtra("image");
            val path = ServiceBuilder.loadImagePath()+image;
            Glide.with(this).load(path).into(imgProfile);

        }
        btnsave.setOnClickListener {
            val name = etname.text.toString();
            val book = etbook.text.toString();
            val address =etaddress.text.toString();
            val email = etemail.text.toString();
            val product= Product(Customer_Name = name,Customer_Address = address,Customer_Email = email,Customer_Book = book);
            CoroutineScope(Dispatchers.IO).launch{
                val productRepo = ProductRepository();
                val response = productRepo.updateProduct(id,product);
                if(response.success==true){
                    withContext(Main){
                    Toast.makeText(this@updateactivity , "Product Updated Successfully", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }
    }
    
}