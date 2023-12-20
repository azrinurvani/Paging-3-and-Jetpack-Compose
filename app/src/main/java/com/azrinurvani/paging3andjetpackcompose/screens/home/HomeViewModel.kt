package com.azrinurvani.paging3andjetpackcompose.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.azrinurvani.paging3andjetpackcompose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: Repository
) : ViewModel(){
    val getAllImages = repository.getAllImages()
}