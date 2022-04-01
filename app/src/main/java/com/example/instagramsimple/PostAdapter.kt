package com.example.instagramsimple

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramsimple.fragments.HomeFragment
import com.example.instagramsimple.fragments.TimeFormatter
import java.util.*

class PostAdapter(val context: Context, val posts: List<Post>): RecyclerView.Adapter<PostAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        // Specify the layout file to use for this item

        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts.get(position)
        // Set time difference
        val formattedTime = TimeFormatter.getTimeDifference("createdAt")

        holder.bind(post)
        holder.tvTimeStamp.text = formattedTime

    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val username:TextView
        val ivFileView: ImageView
        val tvDescription: TextView
        val tvTimeStamp: TextView

        init {
            username = itemView.findViewById(R.id.user_name)
            ivFileView = itemView.findViewById(R.id.ivFileView)
            tvDescription = itemView.findViewById(R.id.tvDescription)
            tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp)
        }

        fun bind(post: Post){
            tvDescription.text = post.getDescription()
            username.text = post.getUser()?.username

            //Populate Image
            Glide.with(itemView.context).load(post.getImage()?.url).into(ivFileView)

            tvTimeStamp.text = post.getTime(createdAt : Date).toString()

        }
    }

}