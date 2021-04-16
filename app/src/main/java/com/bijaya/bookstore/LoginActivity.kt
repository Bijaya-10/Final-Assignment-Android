package com.bijaya1.weekfiveassignmentone

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.MainActivity2
import com.bijaya.bookstore.NotificationChannels
import com.bijaya.bookstore.ProductActivity
import com.bijaya.bookstore.grid
import com.bijaya.bookstore.repository.CustomerRepository
import com.bijaya1.weekfiveassignmentone.Users.Users
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private val permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    private var userList = ArrayList<Users>()
    private lateinit var btnLogin: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var signupLink: TextView
    private lateinit var invalid: TextView
    private lateinit var constraintLayout: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        loadUser()
        btnLogin = findViewById(R.id.btnLogin)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        signupLink = findViewById(R.id.signupLink)
        invalid = findViewById(R.id.invalid)
        constraintLayout = findViewById(R.id.constraintLayout)

        signupLink.setOnClickListener {
            startActivity(Intent(this@LoginActivity, Signup_Activity::class.java))
        }


        checkRunTimePermission()

        btnLogin.setOnClickListener {
            if (validateInput()) {
                login();
                showHighPriorityNotification()
            }
        }

    }

    private fun showHighPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("Notification")
            .setContentText("This is home page ")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(1, notification)
    }


    //etUsername.append("${userList.get((userList.size-1)).username}")


    private fun checkRunTimePermission() {
        if (!hasPermission()) {
            requestPermission()
        }
    }

    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
                break
            }
        }
        return hasPermission
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@LoginActivity, permissions, 1)
    }

    private fun login() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = CustomerRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true) {
                    ServiceBuilder.token = "Bearer " + response.token
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                            Snackbar.make(
                                constraintLayout,
                                "Invalid credentials",
                                Snackbar.LENGTH_LONG
                            )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LoginActivity,
                        "$ex", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    fun validateInput(): Boolean {
        if (etUsername.text.toString() == "") {
            etUsername.error = "Please Enter Username"
            return false
        }
        if (etPassword.text.toString() == "") {
            if (etPassword.text.toString() == "") {
                etPassword.error = "Please Enter Password"
                return false
            }

        }
        return true
    }



}