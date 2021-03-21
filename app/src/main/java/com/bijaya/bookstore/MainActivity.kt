package com.bijaya1.weekfiveassignmentone

import android.app.Activity
import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.bijaya.bookstore.Fragments.AboutFragment
import com.bijaya.bookstore.Fragments.ContactFragment
import com.bijaya.bookstore.Fragments.HomeFragment
import com.bijaya.bookstore.ProductActivity
import com.bijaya.bookstore.adapter.ViewPagerAdapter
import com.bijaya.bookstore.grid
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.bijaya1.weekfiveassignmentone.Users.Post
import com.bijaya1.weekfiveassignmentone.Users.Users
import com.bijaya1.weekfiveassignmentone.adapter.PostAdapter
import com.bijaya1.weekfiveassignmentone.adapter.UserAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
        private lateinit var btnhomefragment: Button
    private lateinit var btnaboutfragment: Button
    private lateinit var btncontactfragment: Button
    private lateinit var btnread:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnhomefragment = findViewById(R.id.btnhome)
        btnaboutfragment = findViewById(R.id.btnabout)
        btncontactfragment = findViewById(R.id.btncontact)
        btnread = findViewById(R.id.btnread)


btnhomefragment.setOnClickListener{
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.linearcontainer, HomeFragment())
        addToBackStack(null)
        commit()
    }
}

        btnaboutfragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearcontainer, AboutFragment())
                addToBackStack(null)
                commit()
        }
        }


        btncontactfragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearcontainer, ContactFragment())
                addToBackStack(null)
                commit()
            }
        }


        btnread.setOnClickListener {
            val intent = Intent(this, grid::class.java)
          startActivity(intent)
        }


    }
}





//    private lateinit var lstTitle: ArrayList<String>
//    private lateinit var lstFragments: ArrayList<Fragment>
//    private lateinit var viewPager: ViewPager2
//    private  lateinit var tableLayout: TableLayout
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        viewPager = findViewById(R.id.viewpager)
//        tableLayout = findViewById(R.id.tablayout)
//
//        populatelist()
//        val adapter = ViewPagerAdapter(lstFragments,supportFragmentManager,lifecycle)
//        viewPager.adapter = adapter
//        TabLayoutMediator(tableLayout,viewPager){
//            tab, Position ->
//            tab.text = lstTitle[Position]
//
//        }.attach()
//    }
//
//    private fun populatelist(){
//        lstTitle = ArrayList<String>()
//        lstTitle.add("Sum")
//        lstTitle.add("Area of circle")
//        lstFragments = ArrayList<Fragment>()
//        lstFragments.add(HomeFragment())
//        lstFragments.add(AboutFragment())
//
//
//
//    }






//    private var userList = arrayListOf<Users>()
//    private var postList = ArrayList<Post>()
//    private lateinit var stories: RecyclerView
//    private lateinit var feed: RecyclerView


//    private lateinit var addPost: FloatingActionButton
//    private lateinit var search: EditText
//    private lateinit var currentUser: String
//    private lateinit var profile: String
//    private lateinit var btnLogin: Button



//    private lateinit var btnSave:Button
//

//        btnSave=findViewById(R.id.btnsave)
//        btnSave.setOnClickListener{
//            startActivity(Intent(this@MainActivity,ProductActivity::class.java))
//        }




//        addPost.setOnClickListener(this)
//        loadPost()
//        val intent = intent
//        currentUser = intent.getStringExtra("currentUser").toString()
//        profile = intent.getStringExtra("profile").toString()
//        userList = intent.getParcelableArrayListExtra<Users>("userList") as ArrayList<Users>
//        loadUser()
////        profile = intent.getStringExtra("profile").toString()
//        val storyAdapter = UserAdapter(userList, this)
//        //val stotyAdapter = StoryAdapter(storyList, this)
//        val feetAdapter = PostAdapter(postList, this)
//        val mLayoutManager = LinearLayoutManager(this)
//        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        stories.layoutManager = mLayoutManager
//        feed.layoutManager = LinearLayoutManager(this)
//        feed.adapter = feetAdapter
//        stories.adapter = storyAdapter
//    }
//    private fun loadUser(){
//        userList.add(Users(1, "bhanubhakta", "bhandari", "bhanubhakta123", "password","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FThis-Time-Will-Different-Permanent-ebook%2Fdp%2FB076QJQVNC&psig=AOvVaw0_P56gxupqbtir2kL7wMxz&ust=1614440679135000&source=images&cd=vfe&ved=0CAYQjRxqFwoTCPjX2a3yh-8CFQAAAAAdAAAAABAD", "24B"))
//        userList.add(Users(2, "sabin", "chapagain", "sabin123", "password","https://ik.imagekit.io/panmac/tr:q-75,di-placeholder_portrait_aMjPtD9YZ.jpg,w-350,pr-true,bl/edition/9781529032741.jpg","24B"))
//        userList.add(Users(3, "ramesh", "bhandari", "ramesh123", "password","https://images2.penguinrandomhouse.com/cover/9780399564277", "25A"))
//        userList.add(Users(4, "unish", "bhattarai", "unish123", "password","https://cdn.waterstones.com/bookjackets/large/9781/7864/9781786495259.jpg", "24B"))
//        userList.add(Users(5, "Anish", "Nepal", "anish123", "password","https://dynamic.indigoimages.ca/books/031242678x.jpg?quality=85&width=380&maxheight=515&lang=en", "24B"))
//        userList.add(Users(6, "Saurav", "Parajuli", "saurav123", "password","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRtasQocLeuvDto0VSNZJI-XNUUI-3cDiKIA&usqp=CAU", "24B"))
//        userList.add(Users(7, "Roman", "Dulal", "roman123", "password","https://images.gr-assets.com/books/1415375471l/119073.jpg", "24B"))
//    }
//    private fun loadPost(){
//        postList.add(Post("dfidfi", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FThis-Time-Will-Different-Permanent-ebook%2Fdp%2FB076QJQVNC&psig=AOvVaw0_P56gxupqbtir2kL7wMxz&ust=1614440679135000&source=images&cd=vfe&ved=0CAYQjRxqFwoTCPjX2a3yh-8CFQAAAAAdAAAAABAD", "Happy Birthday Bro", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FThis-Time-Will-Different-Permanent-ebook%2Fdp%2FB076QJQVNC&psig=AOvVaw0_P56gxupqbtir2kL7wMxz&ust=1614440679135000&source=images&cd=vfe&ved=0CAYQjRxqFwoTCPjX2a3yh-8CFQAAAAAdAAAAABAD"))
//        postList.add(Post("fjsjds", "https://images-na.ssl-images-amazon.com/images/I/41tTZ6cwHHL.jpg","Happy Married Life Jaya", "https://images-na.ssl-images-amazon.com/images/I/41tTZ6cwHHL.jpg"))
//        postList.add(Post("rfdfdf","https://ik.imagekit.io/panmac/tr:q-75,di-placeholder_portrait_aMjPtD9YZ.jpg,w-350,pr-true,bl/edition/9781529032741.jpg", "Hey there!","https://ik.imagekit.io/panmac/tr:q-75,di-placeholder_portrait_aMjPtD9YZ.jpg,w-350,pr-true,bl/edition/9781529032741.jpg"))
//        postList.add(Post("Afsdfs", "https://images2.penguinrandomhouse.com/cover/9780399564277","This is My status","https://images2.penguinrandomhouse.com/cover/9780399564277"))
//        postList.add(Post("sabsfsfin", "https://cdn.waterstones.com/bookjackets/large/9781/7864/9781786495259.jpg","Beauty of Kathmandu","https://cdn.waterstones.com/bookjackets/large/9781/7864/9781786495259.jpg"))
//        postList.add(Post("sffavff", "https://dynamic.indigoimages.ca/books/031242678x.jpg?quality=85&width=380&maxheight=515&lang=en","This is My status","https://dynamic.indigoimages.ca/books/031242678x.jpg?quality=85&width=380&maxheight=515&lang=en"))
//        postList.add(Post("sabidfdfdfn", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRtasQocLeuvDto0VSNZJI-XNUUI-3cDiKIA&usqp=CAU","My Friend","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRtasQocLeuvDto0VSNZJI-XNUUI-3cDiKIA&usqp=CAU"))
//        postList.add(Post("Rosfsfs", "https://images.gr-assets.com/books/1415375471l/119073.jpg","My lovely Sister","https://images.gr-assets.com/books/1415375471l/119073.jpg"))
//
//    }
//
////    private fun loadStories(){
////
////    }
//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.addPost->{
//                val intent = Intent(this, PostActivity::class.java)
//                startActivityForResult(intent, 1)
//            }
//        }
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode==1){
//            if(resultCode== Activity.RESULT_OK){
//                val status = data?.getStringExtra("status").toString()
//                val link = data?.getStringExtra("link").toString()
//                postList.add(Post(currentUser,profile, status, link))
//            }
//        }
//    }
