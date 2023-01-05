package com.artemissoftware.data.models


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artemissoftware.data.util.Constants
import com.google.gson.annotations.SerializedName

@Entity(tableName = Constants.UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: String,
    @Embedded
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("likes")
    val likes: Int,
    @Embedded
    @SerializedName("user")
    val user: User,
)
