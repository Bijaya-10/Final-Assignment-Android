package com.bijaya.bookstore

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.bijaya1.weekfiveassignmentone.R

class contact : AppCompatActivity() {

    internal  var number:String?=""


    private lateinit var btnhome1: Button
    private lateinit var btnabout1: Button
    private lateinit var btncontact1: Button
    private lateinit var dialBtn: Button
    private lateinit var numberEt : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)


        btnhome1 = findViewById(R.id.btnhome1)
        btnabout1 = findViewById(R.id.btnabout1)
        btncontact1 = findViewById(R.id.btncontact1)
        dialBtn = findViewById(R.id.dialBtn)
        numberEt = findViewById(R.id.numberEt)



        dialBtn.setOnClickListener {
            number = numberEt.text.toString().trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(number)))
            startActivity(intent)
        }


        btnhome1.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        btnabout1.setOnClickListener {
            val intent = Intent(this, about::class.java)
            startActivity(intent)
        }
        btncontact1.setOnClickListener {
            val intent = Intent(this, contact::class.java)
            startActivity(intent)
        }

    }
}