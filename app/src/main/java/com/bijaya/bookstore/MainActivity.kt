package com.bijaya1.weekfiveassignmentone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.bijaya1.weekfiveassignmentone.Users.Post
import com.bijaya1.weekfiveassignmentone.Users.Users
import com.bijaya1.weekfiveassignmentone.adapter.PostAdapter
import com.bijaya1.weekfiveassignmentone.adapter.UserAdapter

class MainActivity : AppCompatActivity(){

    private var userList = arrayListOf<Users>()
    private var postList = ArrayList<Post>()
    private lateinit var stories: RecyclerView
    private lateinit var feed: RecyclerView
    private lateinit var addPost: FloatingActionButton
    private lateinit var search: EditText
    private lateinit var currentUser: String
    private lateinit var profile: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
}
}