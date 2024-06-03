package com.adiandroid.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val description: String,
    val photo: Int,
    val bg: Int,
    val age: String,
    val cast: String,
    val listbg: Int
) : Parcelable