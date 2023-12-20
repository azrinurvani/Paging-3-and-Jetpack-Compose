package com.azrinurvani.paging3andjetpackcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.azrinurvani.paging3andjetpackcompose.Constants

@Entity(tableName = Constants.UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(

    @PrimaryKey(autoGenerate = false)
    val id : String,
    val prevPage  : Int?,
    val nextPage : Int?
)
