package com.example.co.designapp.ui.gallery

import androidx.lifecycle.ViewModel
import com.example.co.designapp.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private  val unspalsrep:UnsplashRepository
):ViewModel() {
}