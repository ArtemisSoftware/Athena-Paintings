package com.artemissoftware.athenapaintings.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.artemissoftware.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: RepositoryImpl
): ViewModel() {
    val getAllImages = repository.getAllImages()
}