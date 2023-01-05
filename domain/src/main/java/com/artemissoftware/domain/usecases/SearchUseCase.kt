package com.artemissoftware.domain.usecases

import androidx.paging.PagingData
import com.artemissoftware.domain.Repository
import com.artemissoftware.domain.UnsplashImageUi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(query: String): Flow<PagingData<UnsplashImageUi>> = repository.searchImages(query)
}