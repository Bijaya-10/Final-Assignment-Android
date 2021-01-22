package com.bijaya1.weekfiveassignmentone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class PostActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var tvStatus:EditText
    private lateinit var tvLink:EditText
    private lateinit var btnPost: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        tvStatus=findViewById(R.id.tvStatus)
        tvLink=findViewById(R.id.tvLink)
        btnPost=findViewById(R.id.btnPost)
        btnPost.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnPost->{
                val status = tvStatus.text.toString()
                val link = tvLink.text.toString()
                val intent = Intent()
                intent.putExtra("status", status)
                intent.putExtra("link", link)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }
    }
}