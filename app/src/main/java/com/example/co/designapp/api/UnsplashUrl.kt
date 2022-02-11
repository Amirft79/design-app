package com.example.co.designapp.api

import com.example.co.designapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashUrl {

    companion object{
        const val Base_Url="https://api.unsplash.com/"
        const val Client_Id=BuildConfig.UNSPLASH_ACCESS_KEY
    }


    @GET("/search/photos")
    suspend fun searchphoto(
        @Query("query") query:String,
        @Query("page") page:Int,
        @Query("per_page") perpage:Int
    )
}