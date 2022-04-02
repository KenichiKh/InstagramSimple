package com.example.instagramsimple

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import java.util.*


//Description : String
//Image : File
//User : User
//updatedAt : Date
@ParseClassName("Post")
class Post : ParseObject() {

    fun getDescription() : String?{
        return getString(KEY_DESCRIPTION)
    }
    fun setDescription(description: String){
        put(KEY_DESCRIPTION, description)
    }
    fun getImage() : ParseFile?{
        return getParseFile(KEY_IMAGE)
    }
    fun setImage(parseFile: ParseFile) {
        put(KEY_IMAGE, parseFile)
    }
    fun getUser():ParseUser?{
        return getParseUser(KEY_USER)
    }
    fun setUser(user: ParseUser){
        put(KEY_USER, user)
    }

    fun getTime(): Date? {
        return getDate(KEY_TIME)
    }

    fun setTime(date: Date){
        put(KEY_TIME, createdAt)
    }

    companion object{
        const val KEY_DESCRIPTION = "description"
        const val KEY_IMAGE = "Image"
        const val KEY_USER = "user"
        const val KEY_TIME = "createdAt"
    }
}