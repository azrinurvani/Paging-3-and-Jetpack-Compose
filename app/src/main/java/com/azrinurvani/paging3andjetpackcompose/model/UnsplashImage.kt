package com.azrinurvani.paging3andjetpackcompose.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.azrinurvani.paging3andjetpackcompose.Constants
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = Constants.UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false) //autoGenerate false karena id sudah unique dan diinput dari response
    val id : String,
    @Embedded
    val urls: Urls,
    var likes : Int,
    @Embedded
    val user : User
)
