package com.artemissoftware.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.artemissoftware.data.database.dao.UnsplashImageDao
import com.artemissoftware.data.database.dao.UnsplashRemoteKeysDao
import com.artemissoftware.data.models.UnsplashImage
import com.artemissoftware.data.models.UnsplashRemoteKeys

@Database(
    entities = [UnsplashImage::class, UnsplashRemoteKeys::class],
    version = 1
)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}