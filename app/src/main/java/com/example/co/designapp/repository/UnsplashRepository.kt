package com.example.co.designapp.repository

import com.example.co.designapp.api.UnsplashUrl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(
    private val unsplashapi:UnsplashUrl
) {
}