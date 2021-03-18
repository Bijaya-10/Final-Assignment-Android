package com.bijaya.bookstore.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bijaya.bookstore.API.ServiceBuilder
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.repository.ProductRepository
import com.bijaya1.weekfiveassignmentone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProductAdapter(
    private val context: Context,
    private val lstProduct: ArrayList<Product>

) : RecyclerView.Adapter<ProductAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val imgProfile: ImageView = view.findViewById(R.id.imgProfile)
        val tvbookname: TextView = view.findViewById(R.id.tvbookname)
        val tvbooknumber: TextView = view.findViewById(R.id.tvbooknumber)
        val delete: ImageView = view.findViewById(R.id.delete)
        val edit: ImageView = view.findViewById(R.id.edit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_product, parent, false)
        return StudentViewHolder(view)
    }
    override fun getItemCount(): Int {
        return lstProduct.size;
    }

    override fun onBindViewHolder(holder: ProductAdapter.StudentViewHolder, position: Int) {
        val product = lstProduct[position]
        holder.tvbookname.text = product.Book_Name
        holder.tvbooknumber.text = product.Book_Number


//        holder.edit.setOnClickListener {
//            val intent = Intent(context,UpdateActivity::class.java)
//            intent.putExtra("student",student)
//            context.startActivity(intent)
//        }

//        holder.delete.setOnClickListener {
//            val imagePath = ServiceBuilder.loadImagePath() + product.Book_Image
////            if (!product.Book_Image.equals("no-photo.jpg")) {
////                Glide.with(context)
////                    .load(imagePath)
////                    .fitCenter()
////                    .into(holder.imgProfile)
////            }
//
//            val builder = AlertDialog.Builder(context)
//            builder.setTitle("Delete Student")
//            builder.setMessage("Are You Sure You Want To Delete  ${product.Book_Name} ?")
//            builder.setIcon(android.R.drawable.ic_dialog_alert)
//            builder.setPositiveButton("Yes") { _, _ ->
//
//                CoroutineScope(Dispatchers.IO).launch {
//                    try {
//                        val productRepository = ProductRepository()
//                        val response = productRepository.deleteProduct(product._id!!)
//                        if (response.success == true) {
//                            withContext(Dispatchers.Main) {
//                                Toast.makeText(
//                                    context,
//                                    "Student Deleted",
//                                    Toast.LENGTH_SHORT
//                                )
//                                    .show()
//                            }
//                        }
//                        withContext(Dispatchers.Main) {
//                            lstProduct.remove(product)
//                            notifyDataSetChanged()
//                        }
//
//                    } catch (ex: Exception) {
//                        withContext(Dispatchers.Main) {
//                            Toast.makeText(
//                                context,
//                                ex.toString(),
//                                Toast.LENGTH_SHORT
//                            )
//                                .show()
//                        }
//                    }
//                }
//            }
//
//
//            builder.setNegativeButton("No") { _, _ ->
//                Toast.makeText(context, "Action Cancelled", Toast.LENGTH_SHORT).show()
//            }
//
//            val alertDialog: AlertDialog = builder.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
//        }
    }


}