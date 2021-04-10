package com.bijaya.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.widget.Button
import android.widget.Toast
import com.bijaya1.weekfiveassignmentone.R
import com.synnapps.carouselview.CarouselView

class about : AppCompatActivity() {

    private lateinit var carouselView: CarouselView

    private lateinit var btnhome2: Button
    private lateinit var btnabout2: Button
    private lateinit var btncontact2: Button

    var sampleImages = intArrayOf(
        R.drawable.i22,
        R.drawable.i19,
        R.drawable.i8,
        R.drawable.book1
    )
    var books = arrayOf(
        "The Name Jar",
        "The Power Of One",
        "One Indian Girl",
        "The Name They Gave Us"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        carouselView = findViewById(R.id.carouselView)
        carouselView.pageCount = books.size
        btnhome2 = findViewById(R.id.btnhome2)
        btnabout2 = findViewById(R.id.btnabout2)
        btncontact2 = findViewById(R.id.btncontact2)

        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(sampleImages[position])
        }
        carouselView.setImageClickListener {position ->
            Toast.makeText(applicationContext, books[position], Toast.LENGTH_SHORT).show()
        }

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