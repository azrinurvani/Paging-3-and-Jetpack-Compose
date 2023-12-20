package com.azrinurvani.paging3andjetpackcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.azrinurvani.paging3andjetpackcompose.data.local.dao.UnsplashImageDao
import com.azrinurvani.paging3andjetpackcompose.data.local.dao.UnsplashRemoteKeysDao
import com.azrinurvani.paging3andjetpackcompose.model.UnsplashImage
import com.azrinurvani.paging3andjetpackcompose.model.UnsplashRemoteKeys

@Database(entities = [
    UnsplashImage::class,
    UnsplashRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class UnsplashDatabase : RoomDatabase(){
    abstract fun unsplashImageDao() : UnsplashImageDao
    abstract fun unsplashRemoteKeysDao() : UnsplashRemoteKeysDao
}