package com.example.co.designapp.di

import com.example.co.designapp.api.UnsplashUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun retrofit():Retrofit=
        Retrofit.Builder()
            .baseUrl(UnsplashUrl.Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Provides
    @Singleton
    fun ProvideUnsplashApi(retrofit: Retrofit):UnsplashUrl=
        retrofit.create(UnsplashUrl::class.java)
}