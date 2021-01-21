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

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var userList = arrayListOf<Users>()
    private var postList = ArrayList<Post>()
    private lateinit var stories:RecyclerView
    private lateinit var feed:RecyclerView
    private lateinit var addPost:FloatingActionButton
    private lateinit var search:EditText
    private lateinit var currentUser:String
    private lateinit var profile:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stories = findViewById(R.id.stories)
        feed = findViewById(R.id.feed)
        addPost = findViewById(R.id.addPost)
        search = findViewById(R.id.search)

        addPost.setOnClickListener(this)
        loadPost()
        val intent = intent
        currentUser = intent.getStringExtra("currentUser").toString()
        profile = intent.getStringExtra("profile").toString()
        userList = intent.getParcelableArrayListExtra<Users>("userList") as ArrayList<Users>
        loadUser()
//        profile = intent.getStringExtra("profile").toString()
        val storyAdapter = UserAdapter(userList, this)
        //val stotyAdapter = StoryAdapter(storyList, this)
        val feetAdapter = PostAdapter(postList, this)
        val mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        stories.layoutManager = mLayoutManager
        feed.layoutManager = LinearLayoutManager(this)
        feed.adapter=feetAdapter
        stories.adapter = storyAdapter
    }
    private fun loadUser(){
        userList.add(Users(10250123, "bhanubhakta", "bhandari", "bhanubhakta123", "password","https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80", "24B"))
        userList.add(Users(10250124, "sabin", "chapagain", "sabin123", "password","https://pbs.twimg.com/media/Bw6VkhPIEAAEXU-?format=jpg&name=small","24B"))
        userList.add(Users(10250125, "ramesh", "bhandari", "ramesh123", "password","https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80", "25A"))
        userList.add(Users(10250126, "unish", "bhattarai", "unish123", "password","https://images.unsplash.com/photo-1441786485319-5e0f0c092803?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80", "24B"))
        userList.add(Users(10250127, "Anish", "Nepal", "anish123", "password","https://images.unsplash.com/photo-1512485694743-9c9538b4e6e0?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80", "24B"))
        userList.add(Users(10250127, "Saurav", "Parajuli", "saurav123", "password","https://images.unsplash.com/photo-1441786485319-5e0f0c092803?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80", "24B"))
        userList.add(Users(10250128, "Roman", "Dulal", "roman123", "password","https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80", "24B"))
    }
    private fun loadPost(){
        postList.add(Post("sabin", "https://pbs.twimg.com/media/Bw6VkhPIEAAEXU-?format=jpg&name=small", "Happy Birthday Bro", "https://pbs.twimg.com/media/Bw6VkhPIEAAEXU-?format=jpg&name=small"))
        postList.add(Post("bhanubhakta", "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80","Happy Married Life Jaya", "https://cdn0.weddingwire.in/articles/images/9/4/1/0/img_10149/indian-wedding-couple-images-mahima-bhatia-photography-lead-image.jpg"))
        postList.add(Post("ramesh","https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80", "Hey there!","https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"))
        postList.add(Post("Anish", "https://images.unsplash.com/photo-1512485694743-9c9538b4e6e0?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80","This is My status",""))
        postList.add(Post("sabin", "https://pbs.twimg.com/media/Bw6VkhPIEAAEXU-?format=jpg&name=small","Beauty of Kathmandu","https://cdn1.i-scmp.com/sites/default/files/styles/120x80/public/images/methode/2019/02/06/3a21faa6-2052-11e9-9b66-f8d7b487d426_image_hires_164133.jpg?itok=N5j7OlEH&v=1549442505"))
        postList.add(Post("saurav", "https://images.unsplash.com/photo-1441786485319-5e0f0c092803?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80","This is My status",""))
        postList.add(Post("sabin", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80","My Friend","https://images.unsplash.com/photo-1509460913899-515f1df34fea?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80"))
        postList.add(Post("Roman", "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80","My lovely Sister","https://upload.wikimedia.org/wikipedia/commons/c/c0/Young_girl_smiling_in_sunshine_%282%29.jpg"))
        postList.add(Post("Unish", "https://images.unsplash.com/photo-1441786485319-5e0f0c092803?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80","Feeling Sad",""))
        postList.add(Post("sabin", "https://pbs.twimg.com/media/Bw6VkhPIEAAEXU-?format=jpg&name=small","Feeling proud to be a student at Softwarica",""))
        postList.add(Post("bhanubhakta", "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80","This is My status",""))
    }

//    private fun loadStories(){
//
//    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.addPost->{
                val intent = Intent(this, PostActivity::class.java)
                startActivityForResult(intent, 1)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                val status = data?.getStringExtra("status").toString()
                val link = data?.getStringExtra("link").toString()
                postList.add(Post(currentUser,profile, status, link))
            }
        }
    }
}