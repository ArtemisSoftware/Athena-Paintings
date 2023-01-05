package com.artemissoftware.domain


import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllImages(): Flow<PagingData<UnsplashImageUi>>
    fun searchImages(query: String): Flow<PagingData<UnsplashImageUi>>
}