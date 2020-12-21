package com.example.afinal

import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface ApiService {

//    @GET("posts/")
//    fun getPosts(): Call<List<Post>>

//    @GET("posts/{id}/")
//    fun getPostById(@Path("id") postId: Int): Call<Post>
//
    @GET("{category}/{country}.json")
    fun getNews(@Path("category") category: String, @Path("country") country: String): Call<InitialObject>
}