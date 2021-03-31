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
import com.bijaya.bookstore.entity.Product
import com.bijaya.bookstore.repository.CustomerOrderRepo
import com.bijaya.bookstore.repository.ProductRepository
import com.bijaya1.weekfiveassignmentone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CustomerAdapter (
    private val context: Context,
    private val lstProduct: ArrayList<Product>

) : RecyclerView.Adapter<CustomerAdapter.ProductViewHolder>() {
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val imgProfile: ImageView = view.findViewById(R.id.imgProfile)
        val tvbookname: TextView = view.findViewById(R.id.tvbookname)
        val tvbooknumber: TextView = view.findViewById(R.id.tvbooknumber)
        val delete: ImageView = view.findViewById(R.id.delete)
        val edit: ImageView = view.findViewById(R.id.edit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerviewcustomerorder, parent, false)
        return ProductViewHolder(view)
    }
    override fun getItemCount(): Int {
        return lstProduct.size;
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = lstProduct[position]
        holder.tvbookname.text = product.Book_Name
        holder.tvbooknumber.text = product.Book_Number

//
//        holder.edit.setOnClickListener {
//            val intent = Intent(context,UpdateActivity::class.java)
//            intent.putExtra("student",student)
//            context.startActivity(intent)
//        }

        holder.delete.setOnClickListener {
//            val imagePath = ServiceBuilder.loadImagePath() + product.Book_Image
//            if (!product.Book_Image.equals("no-photo.jpg")) {
//                Glide.with(context)
//                    .load(imagePath)
//                    .fitCenter()
//                    .into(holder.imgProfile)
//            }

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete ")
            builder.setMessage("Are You Sure You Want To Delete  ${product.Book_Name} ?")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val customerorderRepository = CustomerOrderRepo()
                        val response = customerorderRepository.deleteProduct(product._id!!)
                        if (response.success == true) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    context,
                                    "${response.message}",
                                    Toast.LENGTH_SHORT

                                )
                                    .show()
                            }
                        }
                        withContext(Dispatchers.Main) {
                            lstProduct.remove(product)
                            notifyDataSetChanged()
                        }

                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                context,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            }


            builder.setNegativeButton("No") { _, _ ->
                Toast.makeText(context, "Action Cancelled", Toast.LENGTH_SHORT).show()
            }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }


    }




}