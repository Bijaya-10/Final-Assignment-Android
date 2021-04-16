package com.bijaya.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bijaya1.weekfiveassignmentone.R


class ViewActivity : AppCompatActivity() {

    private lateinit var viewName: TextView;
    private lateinit var viewImage: ImageView
    private lateinit var desc1: TextView;
    private lateinit var desc2: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        viewImage = findViewById(R.id.viewImage)
        viewName = findViewById(R.id.viewName)
        desc1 = findViewById(R.id.descriptionOne);
        desc2 = findViewById(R.id.descriptionTwo);

        var modelItems: Model = intent.getSerializableExtra("data") as Model


        viewName.text = modelItems.name;
        viewImage.setImageResource(modelItems.image!!);
        when (modelItems.name) {
            "Harry Potter" -> {
                desc1.text = getString(R.string.desc12);
                desc2.text = getString(R.string.desc14);


            }
            "Story Thieves" -> {
                desc2.text = getString(R.string.desc15);
            }



            "Owl Babies" -> {
                desc1.text = getString(R.string.desc17);
                desc2.text = getString(R.string.desc16);


            }
            "One Indian Girl" -> {
                desc2.text = getString(R.string.desc15);
            }

            "Story Of My Life" -> {
                desc1.text = getString(R.string.desc12);
                desc2.text = getString(R.string.desc14);


            }
            "Collector of names" -> {
                desc2.text = getString(R.string.desc15);
            }



            "Pirate Tale" -> {
                desc1.text = getString(R.string.desc12);
                desc2.text = getString(R.string.desc14);


            }
            "Charlotte's Web" -> {
                desc2.text = getString(R.string.desc15);
            }

















        }

    }
}