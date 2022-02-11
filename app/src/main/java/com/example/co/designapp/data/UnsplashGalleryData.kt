package com.example.co.designapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class UnsplashGalleryData(
    val id:String,
    val description:String,
    val user:Unsplashuser,
    val urls:Unsplashurls
): Parcelable{
}
@Parcelize
data class Unsplashurls (
    val username:String,
    val name:String
):Parcelable{
}
@Parcelize
data class Unsplashuser(
    val raw :String ,
    val regular:String,
    val thumb:String
) : Parcelable{

}
