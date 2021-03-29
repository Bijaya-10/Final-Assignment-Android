package com.bijaya.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bijaya1.weekfiveassignmentone.LoginActivity
import com.bijaya1.weekfiveassignmentone.MainActivity
import com.bijaya1.weekfiveassignmentone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_)


        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            startActivity(
                Intent(
                    this@Splash_Activity,
                    MainActivity::class.java
                )
            )
            finish()
        }
    }

}