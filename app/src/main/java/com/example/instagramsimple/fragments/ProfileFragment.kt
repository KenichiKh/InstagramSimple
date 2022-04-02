package com.example.instagramsimple.fragments

import android.util.Log
import com.example.instagramsimple.Post
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

class ProfileFragment: HomeFragment() {

    override fun queryPosts(){

        //Specify which class to query
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        //Find all Post objects
        query.include(Post.KEY_USER)
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser())
        // Return posts in descending order: ie newer posts will appear first
        query.addDescendingOrder("createdAt")
        // Only return 20 posts.
        query.limit = 20
        query.findInBackground (object : FindCallback<Post> {
            override fun done(posts: MutableList<Post>?, e: ParseException?) {
                if (e!= null){
                    //Something has went wrong
                    Log.e(TAG, "Error fetching posts")
                }else {
                    if (posts != null){
                        for (post in posts){
                            Log.i(TAG, "Post: " + post.getDescription() + ", Date: " + post.getTime())
                        }
                        allPosts.addAll(posts)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }

}