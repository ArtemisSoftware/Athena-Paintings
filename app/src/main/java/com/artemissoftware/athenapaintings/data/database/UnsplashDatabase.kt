package com.artemissoftware.athenapaintings.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.artemissoftware.athenapaintings.data.database.dao.UnsplashImageDao
import com.artemissoftware.athenapaintings.data.database.dao.UnsplashRemoteKeysDao
import com.artemissoftware.athenapaintings.data.models.UnsplashImage
import com.artemissoftware.athenapaintings.data.models.UnsplashRemoteKeys

@Database(
    entities = [UnsplashImage::class, UnsplashRemoteKeys::class],
    version = 1
)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}