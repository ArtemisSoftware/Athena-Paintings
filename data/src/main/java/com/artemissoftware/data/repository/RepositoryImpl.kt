package com.artemissoftware.data.repository

import androidx.paging.*
import com.artemissoftware.data.database.UnsplashDatabase
import com.artemissoftware.data.models.UnsplashImage
import com.artemissoftware.data.paging.SearchPagingSource
import com.artemissoftware.data.paging.UnsplashRemoteMediator
import com.artemissoftware.data.remote.UnsplashApi
import com.artemissoftware.data.util.Constants.ITEMS_PER_PAGE
import com.artemissoftware.domain.Repository
import com.artemissoftware.domain.UnsplashImageUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ExperimentalPagingApi
class RepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
): Repository {

    override fun getAllImages(): Flow<PagingData<UnsplashImageUi>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map {
                UnsplashImageUi(
                    id = it.id,
                    regularUrl = it.urls.regular,
                    likes = it.likes,
                    username = it.user.username)
            }
        }
    }

    override fun searchImages(query: String): Flow<PagingData<UnsplashImageUi>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = query)
            }
        ).flow.map {
            it.map {
                UnsplashImageUi(
                    id = it.id,
                    regularUrl = it.urls.regular,
                    likes = it.likes,
                    username = it.user.username)
            }
        }
    }



}