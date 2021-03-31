package com.bijaya.bookstore

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bijaya1.weekfiveassignmentone.R

class contact : AppCompatActivity() {

    internal  var number:String?=""

    private lateinit var btnhome1: Button
    private lateinit var btnabout1: Button
    private lateinit var btncontact1: Button
    private lateinit var dialBtn: Button
    private lateinit var sendEmailBtn: Button
    private lateinit var numberEt : EditText
    private lateinit var subjectEt : EditText
    private lateinit var messageEt : EditText
    private lateinit var recipientEt : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)


        btnhome1 = findViewById(R.id.btnhome1)
        btnabout1 = findViewById(R.id.btnabout1)
        btncontact1 = findViewById(R.id.btncontact1)
        dialBtn = findViewById(R.id.dialBtn)
        dialBtn = findViewById(R.id.dialBtn)
        sendEmailBtn = findViewById(R.id.sendEmailBtn)
        numberEt = findViewById(R.id.numberEt)
        messageEt = findViewById(R.id.messageEt)
        subjectEt = findViewById(R.id.subjectEt)
        recipientEt = findViewById(R.id.recipientEt)


    sendEmailBtn.setOnClickListener {
    val recipient = recipientEt.text.toString().trim()
//        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(recipient)))
    val message = recipientEt.text.toString().trim()
    val subject = recipientEt.text.toString().trim()

        sendEmail(recipient, subject, message)

}


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

    private fun sendEmail(recipient: String, subject: String, message: String) {
val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT,subject)
        mIntent.putExtra(Intent.EXTRA_TEXT,message)

        try {
startActivity(Intent.createChooser(mIntent,"Choose email client.."))
        }
        catch (
            e: Exception
        ){
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }



    }
}