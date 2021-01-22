package com.bijaya1.weekfiveassignmentone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bijaya1.weekfiveassignmentone.R
import com.bijaya1.weekfiveassignmentone.Users.Users
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(
    val userList: ArrayList<Users>,
    val context: Context
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val storyImage: CircleImageView
        val tvUser: TextView
        init {
            storyImage = view.findViewById(R.id.storyImage)
            tvUser = view.findViewById(R.id.tvUser)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.stories_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
//        holder.storyImage.setImageResource(R.drawable.i)
        holder.tvUser.text = user.fname
        Glide.with(context)
                .load(user.profile)
                .into(holder.storyImage)
    }
}