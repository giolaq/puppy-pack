package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Puppy(
    val id: String,
    val name: String,
    val bree: String,
    val age: String,
    val description: String? = null,
    @DrawableRes
    val imageId: Int,
    @DrawableRes
    val imageThumbId: Int
)
