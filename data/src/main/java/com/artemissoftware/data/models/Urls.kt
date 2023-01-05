package com.artemissoftware.data.models


import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("regular")
    val regular: String,
)