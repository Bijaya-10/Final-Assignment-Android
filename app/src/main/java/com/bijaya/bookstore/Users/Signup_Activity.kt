package com.bijaya1.weekfiveassignmentone

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.*
import android.widget.Toast.makeText
import com.bijaya.bookstore.entity.customer
import com.bijaya.bookstore.repository.CustomerRepository
import com.bijaya1.weekfiveassignmentone.Users.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Signup_Activity : AppCompatActivity(), View.OnClickListener,SensorEventListener {

    private lateinit var btnRegister:Button
    private lateinit var sensorManager: SensorManager;
    private var sensor: Sensor? = null;

    private lateinit var etFname:EditText
    private lateinit var etLname:EditText
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var etCPassword:EditText
    private lateinit var loginLink:TextView

    private var userList = arrayListOf<Users>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_)
        btnRegister = findViewById(R.id.btnRegister)
        etFname = findViewById(R.id.etFname)
        etLname = findViewById(R.id.etLname)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etCPassword= findViewById(R.id.etCPassword)


        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager;
        if (!checkSensor()) {
            return
        } else {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            sensorManager.registerListener(
                this@Signup_Activity,
                sensor,
                SensorManager.SENSOR_DELAY_NORMAL
            );
        }

        loginLink = findViewById(R.id.loginLink)

        btnRegister.setOnClickListener{
            registerUser()
            vibratePhone()
        }





        loginLink.setOnClickListener(this)


    }

    private fun registerUser() {
        val firstname = etFname.text.toString()
        val lastname = etLname.text.toString()
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val CPassword = etCPassword.text.toString()

        if (password != CPassword) {
            etPassword.error = "Password does not match"
            etPassword.requestFocus()
            return
        } else {
            val customer1 = customer(
                firstname = firstname,
                lastname = lastname,
                username = username,
                password = password
            )

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val customerRepository = CustomerRepository()
                    val response = customerRepository.registerUser(customer1)
                    if (response.success == true) {
                        withContext(Main) {
                            Toast.makeText(
                                this@Signup_Activity,
                                "Register Successful",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
                catch (ex: Exception){
                    withContext(Main){
                        Toast.makeText(this@Signup_Activity, ex.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }

            // Api code goes here

        }
    }


    private fun checkSensor(): Boolean {
        var flag = true;
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null) {
            flag = false
        }
        return flag;
    }
    override fun onSensorChanged(event: SensorEvent?) {
        val values = event!!.values[0];
        if (values <= 4) {
            makeText(this, "You blocked the screen.", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    @SuppressLint("ServiceCast")
    private fun vibratePhone() {
        val vibrator = this?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(2000, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(2000)
        }
    }





















    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnRegister ->{
                if (validate()){
                    val customer = customer(etFname.text.toString(), etLname.text.toString(), etUsername.text.toString(), etPassword.text.toString())
                    var intent = Intent();
                    intent.putExtra("user",customer);
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
        if (etCPassword.text.toString()==""){
            return false
            etCPassword.error = "cant be empty"
        }

        return true
    }

    companion object {
        fun loadLogin(activity: Signup_Activity){
            val intent = Intent(activity, LoginActivity ::class.java)
//            intent.putExtra("userlist", activity.userList)
            activity.startActivity(intent)
        }
    }
}

private fun Parcelable.putExtra(s: String, customer: customer) {

}