package com.artemissoftware.athenapaintings.di

import androidx.paging.ExperimentalPagingApi
import com.artemissoftware.data.database.UnsplashDatabase
import com.artemissoftware.data.remote.UnsplashApi
import com.artemissoftware.data.repository.RepositoryImpl
import com.artemissoftware.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideRepository(unsplashApi: UnsplashApi, unsplashDatabase: UnsplashDatabase ): Repository {
        return RepositoryImpl(unsplashApi, unsplashDatabase)
    }
}


