package com.azrinurvani.paging3andjetpackcompose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.util.query
import com.azrinurvani.paging3andjetpackcompose.Constants.ITEMS_PER_PAGE
import com.azrinurvani.paging3andjetpackcompose.data.local.UnsplashDatabase
import com.azrinurvani.paging3andjetpackcompose.data.paging.SearchPagingSource
import com.azrinurvani.paging3andjetpackcompose.data.paging.UnsplashRemoteMediator
import com.azrinurvani.paging3andjetpackcompose.data.remote.UnsplashApi
import com.azrinurvani.paging3andjetpackcompose.model.UnsplashImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {

    fun getAllImages() : Flow<PagingData<UnsplashImage>>{
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi,unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(search:String) : Flow<PagingData<UnsplashImage>>{
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = search)
            }
        ).flow
    }
}