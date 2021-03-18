package com.bijaya.bookstore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bijaya1.weekfiveassignmentone.R

class grid : AppCompatActivity() {

var modelList = ArrayList<Model>(



)

    var names = arrayOf(

            "i5",
            "i7",
            "i8",
        "i4"

    )
    var images = intArrayOf(
        R.drawable.i4,
        R.drawable.i5,
        R.drawable.i7,
        R.drawable.i8
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        for(i in names.indices){
            modelList.add(Model(names[i],images[i]))
        }

        var customAdapter = CustomAdapter(modelList, this);

        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = customAdapter;




    }

    class CustomAdapter(
        var itemModel: ArrayList<Model>,
                var context: Context
    ): BaseAdapter(){

        var LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view;
            if(view==null){
                view = LayoutInflater.inflate(R.layout.row_data,viewGroup,false)
            }

            var tvImageName = view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.imageView)

            tvImageName?.text = itemModel[position].name;
            imageView?.setImageResource(itemModel[position].image!!)

            return view!!
        }

        override fun getCount(): Int {
           return itemModel.size
        }

        override fun getItem(position: Int): Any {

            return itemModel[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }



    }
}