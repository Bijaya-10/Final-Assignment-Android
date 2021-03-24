package com.bijaya.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bijaya1.weekfiveassignmentone.R

class home : AppCompatActivity() {


    private lateinit var btnhome4: Button
    private lateinit var btnabout4: Button
    private lateinit var btncontact4: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        btnhome4 = findViewById(R.id.btnhome4)
        btnabout4 = findViewById(R.id.btnabout4)
        btncontact4 = findViewById(R.id.btncontact4)

        btnhome4.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        btnabout4.setOnClickListener {
            val intent = Intent(this, about::class.java)
            startActivity(intent)
        }
        btncontact4.setOnClickListener {
            val intent = Intent(this, contact::class.java)
            startActivity(intent)
        }
    }
}