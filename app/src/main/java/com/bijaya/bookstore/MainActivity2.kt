package com.bijaya.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bijaya.bookstore.Fragments.ContactFragment
import com.bijaya1.weekfiveassignmentone.R

class MainActivity2 : AppCompatActivity() {


    private lateinit var btnread: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        btnread = findViewById(R.id.btnread)
    }
}


