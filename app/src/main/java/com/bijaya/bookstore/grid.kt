package com.bijaya.bookstore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bijaya1.weekfiveassignmentone.R
import kotlin.math.log

class grid : AppCompatActivity() {
    private lateinit var btncrud: Button
    private lateinit var btnread1: Button
var modelList = ArrayList<Model>(



)

    var names = arrayOf(

            "Harry Potter",
            "Story Thieves",
            "Owl Babies",
            "One Indian Girl",
        "Story Of My Life",
        "Collector of names",
        "Pirate Tale",
        "Charlotte's Web"

    )
    var images = intArrayOf(

        R.drawable.i4,
        R.drawable.i5,
        R.drawable.i7,
        R.drawable.i8,
                R.drawable.i10,
                R.drawable.i11,
                R.drawable.i12,
                R.drawable.i13,
                R.drawable.i14,
                R.drawable.i15,
                R.drawable.i16,


        R.drawable.i17,
        R.drawable.i18,
        R.drawable.i19,
        R.drawable.i20,
        R.drawable.i21,
        R.drawable.i22


    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)


        btncrud = findViewById(R.id.btncrud)
        btnread1 = findViewById(R.id.btnread1)

        for(i in names.indices){
            modelList.add(Model(names[i],images[i]))
        }

        var customAdapter = CustomAdapter(modelList, this);

        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = customAdapter;

gridView.setOnItemClickListener { adapterView, view, i, l ->
    var intent = Intent(this,ViewActivity::class.java)
    intent.putExtra("data",modelList[i])
    startActivity(intent)

}
        btnread1.setOnClickListener {
            val intent = Intent(this,ProductActivity::class.java)
            startActivity(intent)
        }


        btncrud.setOnClickListener {
            val intent = Intent(this, CustomerOrder::class.java)
            startActivity(intent);
        }
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

    fun onDefaultToogleClick(view: View) {

    }

}

private fun Intent.putExtra(s: String, model: Model) {

}
