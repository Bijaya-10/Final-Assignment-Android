package com.bijaya.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.widget.Button
import com.bijaya1.weekfiveassignmentone.R

class about : AppCompatActivity() {



    private lateinit var btnhome2: Button
    private lateinit var btnabout2: Button
    private lateinit var btncontact2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        btnhome2 = findViewById(R.id.btnhome2)
        btnabout2 = findViewById(R.id.btnabout2)
        btncontact2 = findViewById(R.id.btncontact2)

        btnhome2.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        btnabout2.setOnClickListener {
            val intent = Intent(this, about::class.java)
            startActivity(intent)
        }
        btncontact2.setOnClickListener {
            val intent = Intent(this, contact::class.java)
            startActivity(intent)
        }


    }
}