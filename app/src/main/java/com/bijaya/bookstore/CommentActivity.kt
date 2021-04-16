package com.bijaya.bookstore

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.entity.comment
import com.bijaya.bookstore.repository.ProductRepository
import com.bijaya.bookstore.repository.commentRepository
import com.bijaya1.weekfiveassignmentone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class CommentActivity : AppCompatActivity() {


    private lateinit var etname: EditText
    private lateinit var etbook: EditText



    private lateinit var btnsave: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        etname = findViewById(R.id.etname)
        etbook = findViewById(R.id.etbook)


        btnsave = findViewById(R.id.btnsave)




        btnsave.setOnClickListener {
            val customername = etname.text.toString()

            val customerbook = etbook.text.toString()


            val Comment = comment(Book_Name = customername,Book_Number = customerbook,)

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val CommentRepository = commentRepository()
                    val response = CommentRepository.addProduct(Comment)
                    if (response.success == true) {
//                        if (imageUrl != null){
//                            uploadImage(response.data!!._id!!)
//                        }
                        withContext(Dispatchers.Main) {

                            Toast.makeText(
                                this@CommentActivity,

                                "Commented",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        startActivity(Intent(this@CommentActivity, ViewComment::class.java));
                    }
                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@CommentActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        }

    }

//    private fun uploadImage(studentId: String) {
//        if (imageUrl != null) {
//            val file = File(imageUrl!!)
//            val reqFile =
//                RequestBody.create(MediaType.parse("multipart/form-data"), file)
//            val body =
//                MultipartBody.Part.createFormData("file", file.name, reqFile)
//            CoroutineScope(Dispatchers.IO).launch {
//                try {
//                    val studentRepository = ProductRepository()
//                    val response = studentRepository.uploadImage(studentId, body)
//                    if (response.success == true) {
//                        withContext(Dispatchers.Main) {
//                            Toast.makeText(this@CommentActivity, "Uploaded", Toast.LENGTH_SHORT)
//                                .show()
//                        }
//                    }
//                } catch (ex: Exception) {
//                    withContext(Dispatchers.Main) {
//                        Log.d("Mero Error ", ex.localizedMessage)
//                        Toast.makeText(
//                            this@CommentActivity,
//                            ex.localizedMessage,
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            }
//        }
//    }

//    private fun loadPopUpMenu() {
//        val popupMenu = PopupMenu(this@CommentActivity, imgProfile)
//        popupMenu.menuInflater.inflate(R.menu.gallery_camera, popupMenu.menu)
//        popupMenu.setOnMenuItemClickListener { item ->
//            when (item.itemId) {
//                R.id.menuCamera ->
//                    openCamera()
//                R.id.menuGallery ->
//                    openGallery()
//            }
//            true
//        }
//        popupMenu.show()
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == REQUEST_GALLERY_CODE && data != null) {
//                val selectedImage = data.data
//                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
//                val contentResolver = contentResolver
//                val cursor =
//                    contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
//                cursor!!.moveToFirst()
//                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
//                imageUrl = cursor.getString(columnIndex)
//                imgProfile.setImageBitmap(BitmapFactory.decodeFile(imageUrl))
//                cursor.close()
//            } else if (requestCode == REQUEST_CAMERA_CODE && data != null) {
//                val imageBitmap = data.extras?.get("data") as Bitmap
//                val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//                val file = bitmapToFile(imageBitmap, "$timeStamp.jpg")
//                imageUrl = file!!.absolutePath
//                imgProfile.setImageBitmap(BitmapFactory.decodeFile(imageUrl))
//            }
//        }
//    }
//
//    private fun bitmapToFile(
//        bitmap: Bitmap,
//        fileNameToSave: String
//    ): File? {
//        var file: File? = null
//        return try {
//            file = File(
//                getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//                    .toString() + File.separator + fileNameToSave
//            )
//            file.createNewFile()
//            //Convert bitmap to byte array
//            val bos = ByteArrayOutputStream()
//            bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos) // YOU can also save it in JPEG
//            val bitMapData = bos.toByteArray()
//            //write the bytes in file
//            val fos = FileOutputStream(file)
//            fos.write(bitMapData)
//            fos.flush()
//            fos.close()
//            file
//        } catch (e: java.lang.Exception) {
//            e.printStackTrace()
//            file // it will return null
//        }
//    }
//
//    private var REQUEST_GALLERY_CODE = 0
//    private var REQUEST_CAMERA_CODE = 1
//    private var imageUrl: String? = null
//
//    private fun openGallery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, REQUEST_GALLERY_CODE)
//    }
//
//    private fun openCamera() {
//        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        startActivityForResult(cameraIntent, REQUEST_CAMERA_CODE)
//    }


}


