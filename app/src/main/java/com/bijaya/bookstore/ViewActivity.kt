package com.bijaya.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bijaya1.weekfiveassignmentone.R



class ViewActivity : AppCompatActivity() {

    private lateinit var viewName : TextView;
    private lateinit var viewImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        var modelItems: Model = intent.getSerializableExtra("data") as Model;
        Log.e("name", modelItems.name.toString());

        viewName.text = modelItems.name;
        viewImage.setImageResource(modelItems.image!!)
    }
}