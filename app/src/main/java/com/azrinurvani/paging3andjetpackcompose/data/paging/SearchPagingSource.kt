package com.azrinurvani.paging3andjetpackcompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.azrinurvani.paging3andjetpackcompose.Constants.ITEMS_PER_PAGE
import com.azrinurvani.paging3andjetpackcompose.data.remote.UnsplashApi
import com.azrinurvani.paging3andjetpackcompose.model.UnsplashImage
import javax.inject.Inject

class SearchPagingSource @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val query: String
): PagingSource<Int, UnsplashImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        val currentPage = params.key ?: 1
        return try {
            val response = unsplashApi.searchImages(query = query, perPage = ITEMS_PER_PAGE)
            val endOfPaginationReached = response.images.isEmpty()
            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return state.anchorPosition
    }
}