package com.bijaya1.weekfiveassignmentone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bijaya1.weekfiveassignmentone.Users.Users

class Signup_Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnRegister:Button

    private lateinit var etCoventryID:EditText
    private lateinit var etFname:EditText
    private lateinit var etLname:EditText
    private lateinit var etProfile:EditText
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var etBatch:Spinner
    private lateinit var loginLink:TextView

    private var userList = arrayListOf<Users>()
    private val batch = arrayListOf("Choose Batch","24B", "25C", "24B")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_)
        btnRegister = findViewById(R.id.btnRegister)
        etCoventryID = findViewById(R.id.etCoventryID)
        etFname = findViewById(R.id.etFname)
        etLname = findViewById(R.id.etLname)
        etProfile = findViewById(R.id.etProfile)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etBatch = findViewById(R.id.etBatch)
        loginLink = findViewById(R.id.loginLink)

        btnRegister.setOnClickListener(this)
        loginLink.setOnClickListener(this)

//        loadUser()
        val adapter = ArrayAdapter(
                this, android.R.layout.simple_list_item_1, batch
        )
        etBatch.adapter= adapter
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnRegister ->{
                if (validate()){
                    val user = Users(etCoventryID.text.toString().toInt(), etFname.text.toString(), etLname.text.toString(), etUsername.text.toString(), etPassword.text.toString(), etProfile.text.toString(),etBatch.toString())
                    var intent = Intent();
                    intent.putExtra("user",user);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
            R.id.loginLink->{
                Companion.loadLogin(this)
            }
        }
    }
//    fun loadUser(){
//        userList.add(Users(10250123, "bhanubhakta", "bhandari", "bhanubhakta123", "password", "24B"))
//        userList.add(Users(10250124, "sabin", "chapagain", "sabin123", "password", "24B"))
//        userList.add(Users(10250125, "ramesh", "bhandari", "ramesh123", "password", "25A"))
//        userList.add(Users(10250126, "unish", "bhattarai", "unish123", "password", "24B"))
//        userList.add(Users(10250127, "Anish", "Nepal", "anish123", "password", "24B"))
//        userList.add(Users(10250127, "Saurav", "Parajuli", "saurav123", "password", "24B"))
//        userList.add(Users(10250128, "Roman", "Dulal", "roman123", "password", "24B"))
//    }

    fun validate():Boolean{
        if (etCoventryID.text.toString()==""){
            return false
            etCoventryID.error = "Please insert CUID "
        }
        if (etFname.text.toString()==""){
            return false
            etFname.error = "this field is empty"
        }
        if (etLname.text.toString()==""){
            return false
            etLname.error = "this field is empty"
        }
        if (etUsername.text.toString()==""){
            return false
            etUsername.error = "Username cant be emptys"
        }
        if (etPassword.text.toString()==""){
            return false
            etPassword.error = "Password cant be empty"
        }
        if (etBatch.toString()=="Choose Batch"){
            return false
            Toast.makeText(this, "Please Select Your Batch", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    companion object {
        fun loadLogin(activity: Signup_Activity){
            val intent = Intent(activity, LoginActivity::class.java)
//            intent.putExtra("userlist", activity.userList)
            activity.startActivity(intent)
        }
    }
}