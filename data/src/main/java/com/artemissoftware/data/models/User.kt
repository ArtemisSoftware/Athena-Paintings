package com.artemissoftware.data.models


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class User(
    @Embedded
    @SerializedName("links")
    val links: UserLinks,

    @SerializedName("username")
    val username: String
)