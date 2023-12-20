package com.azrinurvani.paging3andjetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.azrinurvani.paging3andjetpackcompose.Constants.UNSPLASH_DATABASE
import com.azrinurvani.paging3andjetpackcompose.data.local.UnsplashDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideUnsplashDatabase(@ApplicationContext context: Context) : UnsplashDatabase{
        return Room.databaseBuilder(
            context,
            UnsplashDatabase::class.java,
            UNSPLASH_DATABASE
        ).build()
    }

}