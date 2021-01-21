package com.bijaya1.weekfiveassignmentone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bijaya1.weekfiveassignmentone.R
import com.bijaya1.weekfiveassignmentone.Users.Post
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter(
    val postList:ArrayList<Post>,
    val context: Context
) :RecyclerView.Adapter<PostAdapter.PostViewHolder>()  {
    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvUser: TextView
        val imgProfile:CircleImageView
        val imgPost: ImageView
        val tvStatus: TextView
        init {
            imgPost = view.findViewById(R.id.imgPost)
            imgProfile = view.findViewById(R.id.imgProfile)
            tvUser = view.findViewById(R.id.tvUser)
            tvStatus = view.findViewById(R.id.tvStatus)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
//        var size = 0
//        var a = postList.size
//        for (i in a downTo 0){
//            size = i
//        }
//        return size
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
//        holder.imgPost.setImageResource(R.drawable.i)
        holder.tvUser.text=post.user
        holder.tvStatus.text=post.status
        //Load ikmage with Glide library
        Glide.with(context)
                .load(post.profile)
                .into(holder.imgProfile)
        Glide.with(context)
            .load(post.link)
            .into(holder.imgPost)
    }
}